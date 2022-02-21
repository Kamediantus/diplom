package ru.diplom.diplom.client.constant;

import java.util.*;

public class FrameType {
    public static final String content = "CONTENT";
    public static final String PRODUCTS = "PRODUCTS";
    public static final String ORDERS = "PRODUCTS";
    public static final String STORES = "PRODUCTS";

    public static List<String> getContentIds() {
        List<String> result = new ArrayList<>();
        result.add(PRODUCTS);
        result.add(ORDERS);
        result.add(STORES);
        return result;
    }
}
