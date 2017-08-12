package com.shop.common.utils;

public class UtilOrder {
    public  static String genOrderNum() {
        return (System.currentTimeMillis() + "").substring(1) +
                (System.nanoTime() + "").substring(7, 10);
    }
}
