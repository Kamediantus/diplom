package ru.diplom.diplom.client.services;

import java.util.*;

import org.json.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.entity.*;

public class ProductService {

    public static List<Product> getAllProducts() {
        JSONArray products = new JSONArray(SimpRequest.get(Urls.commonServerUrl + Urls.allProducts).body());
        List<Product> result = new ArrayList<>();
        products.forEach(pr -> {
            Product product = new Product();
            product.setId(((Integer) ((((JSONObject)pr)).get("id"))).longValue());
            product.setPrice(Double.valueOf(((((JSONObject)pr)).get("price").toString())));
            product.setTitle((((JSONObject)pr)).get("title").toString());
            product.setStoreId(((Integer) ((((JSONObject)pr)).get("storeId"))).longValue());
            product.setDescription((((JSONObject)pr)).get("description").toString());
            result.add(product);
        });
        return result;
    }

    public static List<Product> getAllProductsWithFullInfoAndActualPrices() {
        JSONArray products = new JSONArray(SimpRequest.get(Urls.commonServerUrl + Urls.allProducts).body());
        List<Product> result = new ArrayList<>();
        products.forEach(pr -> {
            Product product = new Product();
            product.setId(((Integer) ((((JSONObject)pr)).get("id"))).longValue());
            product.setPrice(Double.valueOf(((((JSONObject)pr)).get("price").toString())));
            product.setTitle((((JSONObject)pr)).get("title").toString());
            product.setStoreId(((Integer) ((((JSONObject)pr)).get("storeId"))).longValue());
            product.setDescription((((JSONObject)pr)).get("description").toString());
            Store store = StoreService.getStoreById(product.getStoreId());
            product.setStore(store);
            result.add(product);
        });
        return result;
    }

}
