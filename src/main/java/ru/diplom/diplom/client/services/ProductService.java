package ru.diplom.diplom.client.services;

import java.net.http.*;
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

    public static Map<Boolean, String> addProduct(String title, String description, String price, String selfLife, String storeName, List<Store> stores) {
        Map<Boolean, String> result = new HashMap<>();
        try {
            Product product = new Product();
            product.setTitle(title);
            product.setDescription(description);
            product.setPrice(Double.parseDouble(price));
            product.setSelfLife(Integer.parseInt(selfLife));
            Store store = stores.stream().filter(item -> Objects.equals(item.getTitle(), storeName)).findFirst().get();
            product.setStoreId(store.getId());
            HttpResponse<String> response = SimpRequest.post(Urls.commonServerUrl + Urls.addProduct,
                    getParamsForAddProduct(product.getTitle(), product.getDescription(), product.getPrice(), product.getSelfLife(), product.getStoreId()));
            if (response.statusCode() == 200) {
                result.put(true, "");
                return result;
            }
            else {
                throw new Exception(response.body());
            }
        } catch (Exception e) {
            result.put(false, e.getMessage());
            return result;
        }
    }

    public static JSONObject getParamsForAddProduct(String title, String description, double price, int selfLife, Long storeId) {
        JSONObject creds = new JSONObject();
        creds.put("title", title);
        creds.put("description", description);
        creds.put("price", price);
        creds.put("selfLife", selfLife);
        creds.put("storeId", storeId);
        return creds;
    }

}
