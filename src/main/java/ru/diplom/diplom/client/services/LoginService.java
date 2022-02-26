package ru.diplom.diplom.client.services;

import java.net.http.*;

import org.json.*;
import ru.diplom.diplom.client.*;

public class LoginService {

    static final String commonServerUrl = "http://localhost:8080";
    static final String singInUrl = "/singIn";
    static final String singUpUrl = "/singUp";
    static final String roleUser = "ROLE_USER";

    public static boolean login(String username, String password) {
        username = "test";
        HttpResponse<String> response = SimpRequest.post(commonServerUrl + singInUrl, getParamsForLogin("test2", "1234"));
        if (response.statusCode() == 200) {
            JSONObject body = new JSONObject(response.body());
            UserSession.getInstace(body.getString("username"), body.getString("role"), body.getString("sessionKey"));
            return true;
        }
        return false;
    }

    public static boolean sungUp(String username, String password, String name, String surname) {
        HttpResponse<String> response = SimpRequest.post(commonServerUrl + singUpUrl,
                getParamsForSingUp(username, password, name, surname));
        if (response.statusCode() == 200) {
            return true;
        }
        return false;
    }

    public static JSONObject getParamsForLogin(String email, String password) {
        JSONObject creds = new JSONObject();
        creds.put("username", email);
        creds.put("password", password);
        return creds;
    }

    public static JSONObject getParamsForSingUp(String email, String password, String name, String surname) {
        JSONObject creds = new JSONObject();
        creds.put("username", email);
        creds.put("name", name);
        creds.put("surname", surname);
        creds.put("password", password);
        return creds;
    }
}
