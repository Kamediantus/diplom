package ru.diplom.diplom.client.services;

import java.util.*;

import org.json.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.entity.*;

public class StoreService {
    public static Store getStoreById(Long id) {
        JSONObject store = new JSONObject(SimpRequest.get(Urls.commonServerUrl + Urls.storeUrl + id).body());
        Store result = new Store(Long.valueOf(store.get("id").toString()), store.get("title").toString(), Double.valueOf(store.get("discount").toString()));
        return result;
    }

    public static List<Store> getAllStores() {
        JSONArray stores = new JSONArray(SimpRequest.get(Urls.commonServerUrl + Urls.allProducts).body());
        List<Store> result = new ArrayList<>();
        stores.forEach(storeItem -> {
            Store store = new Store();
            store.setId(((Integer) ((((JSONObject)storeItem)).get("id"))).longValue());
            store.setTitle((((((JSONObject)storeItem)).get("title"))).toString());
            store.setDiscount(Double.valueOf(((((JSONObject)storeItem)).get("price").toString())));
            result.add(store);
        });
        return result;
    }
}
