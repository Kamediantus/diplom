package ru.diplom.diplom.client.services;

import java.net.http.*;
import java.text.*;
import java.time.*;
import java.util.*;

import org.json.*;
import ru.diplom.diplom.client.constant.*;
import ru.diplom.diplom.client.services.entity.*;

public class ProductLotService {

    public static List<ProductLot> getAllProductLots() {
        JSONArray productLots = new JSONArray(SimpRequest.get(Urls.commonServerUrl + Urls.allProductLots).body());
        List<ProductLot> result = new ArrayList<>();
        productLots.forEach(pr -> {
            Date date = getDateFromMYSQL(((JSONObject)pr).getString("dateOfProduction"), "T");
            ProductLot product = new ProductLot(((JSONObject)pr).getLong("id"), ((JSONObject)pr).getLong("productId"),
                    ((JSONObject)pr).getLong("storeId"), date, ((JSONObject)pr).getInt("shelLife"), ((JSONObject)pr).getInt("count"));
            result.add(product);
        });
        return result;
    }

    public static List<ProductLot> getAllActiveProductLots() {
        JSONArray productLots = new JSONArray(SimpRequest.get(Urls.commonServerUrl + Urls.activeProductLots).body());
        List<ProductLot> result = new ArrayList<>();
        productLots.forEach(pr -> {
            Date date = getDateFromMYSQL(((JSONObject)pr).getString("dateOfProduction"), " ");
            ProductLot product = new ProductLot(((JSONObject)pr).getLong("id"), ((JSONObject)pr).getLong("productId"),
                    ((JSONObject)pr).getLong("storeId"), date, ((JSONObject)pr).getInt("shelLife"), ((JSONObject)pr).getInt("count"));
            product.setFresh(((JSONObject)pr).getBoolean("fresh"));
            result.add(product);
        });
        return result;
    }

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

    private static Date getDateFromMYSQL(String rawDate, String pointer) {
        String onlyDate = rawDate.substring(0, rawDate.indexOf(pointer));
        Date result = null;
        try {
            result = new SimpleDateFormat("yyyy-MM-dd").parse(onlyDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
