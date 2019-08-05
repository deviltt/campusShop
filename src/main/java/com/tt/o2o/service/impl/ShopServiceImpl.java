package com.tt.o2o.service.impl;

import com.tt.o2o.dao.ShopDao;
import com.tt.o2o.dto.ShopExecution;
import com.tt.o2o.entity.Shop;
import com.tt.o2o.enums.ShopStateEnum;
import com.tt.o2o.exceptions.ShopOperationException;
import com.tt.o2o.service.ShopService;
import com.tt.o2o.util.ImageUtil;
import com.tt.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution insertShop(Shop shop, File shopImg) {
        //空值判断，判断shop传进来的值是否合法
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            //店铺初始状态
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectNum = shopDao.insertShop(shop);
            if (effectNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if (shopImg != null) {
                    //存储图片
                    try {
                        addShopImg(shop, shopImg);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error:" + e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectNum = shopDao.updateShop(shop);
                    if (effectNum <= 0) {
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    /**
     * 需要使用shopId来创建目录
     *
     * @param shop
     * @param shopImg
     */
    private void addShopImg(Shop shop, File shopImg) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }
}
