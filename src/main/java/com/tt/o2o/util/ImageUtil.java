package com.tt.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将commonsMultipartFile转换成file
     *
     * @param commonsMultipartFile
     * @return
     */
    public static File transferCommonsMuiltipartFileToFile(CommonsMultipartFile commonsMultipartFile) {
        File newFile = new File(commonsMultipartFile.getOriginalFilename());
        try {
            commonsMultipartFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 处理缩略图，并返回新生成图片的相对值路径，
     *
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(File thumbnail, String targetAddr) {
        String realFileName = getRandomFileName();  //随机名
        String extension = getFileExtension(thumbnail); //扩展名
        makeDirPath(targetAddr);    //创建目标路径文件夹
        String relativeAddr = targetAddr + realFileName + extension;    //相对路径地址
        logger.debug("current relativeAddr is:" + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.8).toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/tt/xxx.jpg
     *
     * @param targetAddr 创建目标路径所涉及到的目录
     */
    private static void makeDirPath(String targetAddr) {
        String realFilePath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFilePath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     *
     * @param thumbnail 文件流
     * @return 返回文件扩展名
     */
    private static String getFileExtension(File thumbnail) {
        String originFileName = thumbnail.getName();    //获取文件名
        return originFileName.substring(originFileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件，当前年月日小时分钟秒钟+五位随机数
     *
     * @return 生成随机文件名
     */
    private static String getRandomFileName() {
        //获取随机五位数
        int randomNum = random.nextInt(89999) + 10000;
        String nowTimeStr = simpleDateFormat.format(new Date());
        return nowTimeStr + randomNum;
    }

    public static void main(String[] args) throws IOException {
        //获取classpath的绝对路径
        //通过线程得到类加载器，得到资源的路径
        System.out.println(basePath);
        //路径、图片大小、水印(位置，透明度
        Thumbnails.of(new File("D:\\lufei.jpg")).size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f).outputQuality(0.8f).toFile("D:\\lufei1.jpg");

    }
}
