package com.tt.o2o.dto;

import com.tt.o2o.entity.Shop;
import com.tt.o2o.enums.ShopStateEnum;

import java.util.List;

public class ShopExecution {
    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //店铺数量
    private int count;

    //操作的shop
    private Shop shop;

    private List<Shop> shopList;

    public ShopExecution() {

    }

    //失败的构造器
    public ShopExecution(ShopStateEnum shopStateEnum) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    //成功的构造器
    public ShopExecution(ShopStateEnum shopStateEnum, Shop shop) {
        this.stateInfo = shopStateEnum.getStateInfo();
        this.state = shopStateEnum.getState();
        this.shop = shop;
    }

    //成功的构造器
    public ShopExecution(ShopStateEnum shopStateEnum, List<Shop> shopList) {
        this.stateInfo = shopStateEnum.getStateInfo();
        this.state = shopStateEnum.getState();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
