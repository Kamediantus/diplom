package ru.diplom.diplom.client.services;

import org.json.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.entity.*;

public class StoreService {
    public static Store getStoreById(Long id) {
        JSONObject store = new JSONObject(SimpRequest.get(Urls.commonServerUrl + Urls.storeUrl + id).body());
        Store result = new Store(Long.valueOf(store.get("id").toString()), store.get("title").toString(), Double.valueOf(store.get("discount").toString()));
        return result;
    }
}
