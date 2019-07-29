package com.tt.o2o.service;

import com.tt.o2o.dto.ShopExecution;
import com.tt.o2o.entity.Shop;

import java.io.File;

public interface ShopService {
    ShopExecution insertShop(Shop shop, File file);
}
