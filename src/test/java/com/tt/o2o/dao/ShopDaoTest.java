package com.tt.o2o.dao;

import com.tt.o2o.BasePath;
import com.tt.o2o.entity.Area;
import com.tt.o2o.entity.PersonInfo;
import com.tt.o2o.entity.Shop;
import com.tt.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BasePath {
    @Autowired
    private ShopDao ShopDao;

    @Test
    public void testUpdateShop(){
        Shop shop=new Shop();
        ShopCategory shopCategory=new ShopCategory();
        Area area=new Area();
        PersonInfo personInfo=new PersonInfo();
        shopCategory.setShopCategoryId(12L);
        shop.setShopId(36L);
        shop.setOwner(personInfo);
        shop.setShopCategory(shopCategory);
        shop.setShopName("test33");
        shop.setShopDesc("描述22");
        shop.setShopAddr("test11");
        shop.setEnableStatus(1);
        int num=ShopDao.updateShop(shop);
        assertEquals(1, num);
    }
}
