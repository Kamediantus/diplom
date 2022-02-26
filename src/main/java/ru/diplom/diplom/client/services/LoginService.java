package ru.diplom.diplom.client.services;

import java.net.http.*;

import org.json.*;

public class LoginService {

    static final String commonServerUrl = "http://localhost:8080";
    static final String singInUrl = "/singIn";
    public static boolean login(String email, String password) {
        HttpResponse<String> response = SimpRequest.post(commonServerUrl + singInUrl, getParamsForLogin("test", "1234"));
        if (response.statusCode() == 200) {
            return true;
        }
        return false;
    }

    public static JSONObject getParamsForLogin(String email, String password) {
        JSONObject params = new JSONObject();
        JSONObject creds = new JSONObject();
        creds.put("username", email);
        creds.put("password", password);
        params.put("creds", creds);
        return creds;
    }
}
