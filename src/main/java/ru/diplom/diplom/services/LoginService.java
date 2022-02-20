package ru.diplom.diplom.services;

import java.net.http.*;

import org.json.*;

public class LoginService {

    static final String commonServerUrl = "http://localhost:8080";
    static final String singInUrl = "/singIn";
    public static boolean login(String email, String password) {
        HttpResponse<String> response = SimpRequest.post(commonServerUrl + singInUrl, getParamsForLogin(email, password));
        if (response.statusCode() == 200) {
            return true;
        }
        return false;
    }

    public static JSONObject getParamsForLogin(String email, String password) {
        JSONObject params = new JSONObject();
        params.put("email", email);
        params.put("password", password);
        return params;
    }
}
