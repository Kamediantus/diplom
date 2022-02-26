package ru.diplom.diplom.client.services;

import java.net.http.*;
import java.util.*;
import java.util.stream.*;

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
        JSONArray stores = new JSONArray(SimpRequest.get(Urls.commonServerUrl + Urls.allStoresUrl).body());
        List<Store> result = new ArrayList<>();
        stores.forEach(storeItem -> {
            Store store = new Store();
            store.setId(((Integer) ((((JSONObject) storeItem)).get("id"))).longValue());
            store.setTitle((((((JSONObject) storeItem)).get("title"))).toString());
            store.setDiscount(Double.valueOf(((((JSONObject) storeItem)).get("discount").toString())));
            result.add(store);
        });
        return result;
    }

    public static Map<Boolean, String> addStore(String title, String discount, List<Store> stores) {
        Map<Boolean, String> result = new HashMap<>();
        HttpResponse<String> response;
        try {
            Store store = new Store();
            store.setTitle(title);
            store.setDiscount(Double.parseDouble(discount));
            if (stores.stream().filter(store1 -> Objects.equals(store1.getTitle(), store.getTitle())).collect(Collectors.toList()).isEmpty()) {
                response = SimpRequest.post(Urls.commonServerUrl + Urls.addStore,
                        getParamsForAddStore(store.getTitle(), store.getDiscount()));
                if (response.statusCode() == 200) {
                    result.put(true, "");
                    return result;
                } else {
                    throw new Exception(response.body());
                }
            }
        }
        catch (Exception e) {
            result.put(false, e.getMessage());
            return result;
        }
        result.put(false, "unknown");
        return result;
    }

    public static JSONObject getParamsForAddStore(String title, Double discount) {
        JSONObject creds = new JSONObject();
        creds.put("title", title);
        creds.put("discount", discount);
        return creds;
    }
}
