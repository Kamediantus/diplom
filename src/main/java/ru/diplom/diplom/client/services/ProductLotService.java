package ru.diplom.diplom.client.services;

import java.net.http.*;
import java.time.*;
import java.util.*;

import org.json.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.entity.*;

public class ProductLotService {

    public static Map<Boolean, String> addProduct(Long storeId, Long productId, int count, LocalDate produceDate) {
        Map<Boolean, String> result = new HashMap<>();
        Date date = Date.from(produceDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        try {
            HttpResponse<String> response = SimpRequest.post(Urls.commonServerUrl + Urls.addProductLot,
                    getParamsForAddProductLot(storeId, productId, count, date.getTime()));
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

    public static JSONObject getParamsForAddProductLot(Long storeId, Long productId, int count, Long produceDate) {
        JSONObject creds = new JSONObject();
        creds.put("storeId", storeId);
        creds.put("productId", productId);
        creds.put("count", count);
        creds.put("produceDate", produceDate);
        return creds;
    }
}
