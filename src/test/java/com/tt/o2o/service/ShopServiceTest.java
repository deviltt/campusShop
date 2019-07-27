package com.tt.o2o.service;

import com.tt.o2o.BasePath;
import com.tt.o2o.entity.Area;
import com.tt.o2o.entity.PersonInfo;
import com.tt.o2o.entity.Shop;
import com.tt.o2o.entity.ShopCategory;
import com.tt.o2o.service.impl.ShopServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BasePath {
    @Autowired
    private ShopServiceImpl shopService;

    @Test
    public void test1(){
        Shop shop=new Shop();
        ShopCategory shopCategory=new ShopCategory();
        Area area=new Area();
        PersonInfo personInfo=new PersonInfo();
        shopCategory.setShopCategoryId(10L);
        personInfo.setUserId(1L);
        area.setAreaId(2);
        shop.setOwner(personInfo);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("test");
        shop.setShopDesc("描述");
        shop.setShopAddr("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        int num=shopService.insertShop(shop);
        assertEquals(1, num);
    }
}
