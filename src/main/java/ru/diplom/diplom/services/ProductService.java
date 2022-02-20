package ru.diplom.diplom.services;

import java.util.*;

import org.json.*;
import ru.diplom.diplom.services.entity.*;

public class ProductService {
    static final String commonServerUrl = "http://localhost:8080";
    static final String singInUrl = "/listAllProducts";

    public static List<Product> getAllProducts() {
        JSONArray products = new JSONArray(SimpRequest.get(commonServerUrl + singInUrl).body());
        List<Product> result = new ArrayList<>();
        products.forEach(pr -> {
            Product product = new Product();
            product.setId(Long.getLong((((JSONObject)pr)).get("id").toString()));
            product.setPrice(Double.valueOf(((((JSONObject)pr)).get("price").toString())));
            product.setTitle((((JSONObject)pr)).get("title").toString());
            product.setStoreId(Long.getLong((((JSONObject)pr)).get("storeId").toString()));
            product.setDescription((((JSONObject)pr)).get("storeId").toString());
            result.add(product);
        });
        return result;
    }

}
