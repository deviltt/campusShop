package com.tt.o2o.service.impl;

import com.tt.o2o.dao.ShopDao;
import com.tt.o2o.entity.Shop;
import com.tt.o2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public int insertShop(Shop shop) {
        return shopDao.insertShop(shop);
    }
}
