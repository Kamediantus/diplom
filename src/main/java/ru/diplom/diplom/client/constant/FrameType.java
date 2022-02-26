package ru.diplom.diplom.client.constant;

import java.util.*;

public class FrameType {
    public static final String content = "CONTENT";
    public static final String PRODUCTS = "PRODUCTS";
    public static final String ORDERS = "ORDERS";
    public static final String STORES = "STORES";
    public static final String SING_IN = "SING_IN";
    public static final String SING_UP = "SING_UP";
    public static final String ADD_PRODUCT = "SING_UP";

    public static List<String> getContentIds() {
        List<String> result = new ArrayList<>();
        result.add(PRODUCTS);
        result.add(ORDERS);
        result.add(STORES);
        return result;
    }
}
