package ru.diplom.diplom.client.services;

import java.net.http.*;

import org.json.*;
import ru.diplom.diplom.client.*;
import ru.diplom.diplom.client.constant.*;

public class OrderService {
    public static boolean addOrder(Long productId, Long storeId, String count) {
        HttpResponse<String> response = SimpRequest.post(Urls.commonServerUrl + Urls.addOrder,
                getParamsForAddOrder(productId, storeId, count));
        if (response.statusCode() == 200) {
            return true;
        }
        return false;
    }

    public static JSONObject getParamsForAddOrder(Long productId, Long storeId, String count) {
        JSONObject creds = new JSONObject();
        creds.put("productId", productId);
        creds.put("storeId", storeId);
        creds.put("count", count);
        creds.put("sessionKey", UserSession.instance.getSessionKey());
        return creds;
    }
}
