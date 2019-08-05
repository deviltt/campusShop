package com.tt.o2o.exceptions;

/**
 * 这样可以明显表示出这个是店铺相关操作的异常
 */
public class ShopOperationException extends RuntimeException {
    //构造函数，继承自RuntimeException的构造函数
    public ShopOperationException(String msg) {
        super(msg);
    }
}
