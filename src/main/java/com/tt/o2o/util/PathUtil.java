package com.tt.o2o.util;

/**
 * 存储thumbnailator生成图片存放的位置
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator");

    /**
     * @return 返回项目图片的根路径
     */
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        //放在外面的磁盘上
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D/projectImg/o2o/";
        } else {
            basePath = "/home/tt/image/";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    /**
     * @param shopId 店铺Id
     * @return 根据不同的业务需求，返回项目的子路径
     */
    public static String getShopImagePath(long shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
