package ru.diplom.diplom.services;

import java.io.*;
import java.net.*;
import java.net.http.*;
import com.github.tsohr.*;

public class SimpRequest {

//    static JSONParser parser = new JSONParser();

    public static HttpResponse<String> get(String url, String token) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Accept", "application/json")
                    .header("authorization", "Bearer " + token)
                    .GET()

                    .build();

            response = HttpClient.newBuilder()
                    .authenticator(new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    "username",
                                    "password".toCharArray());
                        }
                    })
                    .build().send(request, HttpResponse.BodyHandlers.ofString());

        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
//            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

//    public static JSONObject getBodyObject(String url, String token) {
//        JSONObject result = null;
//        try {
//            result = (JSONObject) parser.parse(get(url, token).body());
//        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    public static HttpResponse<String> post(String url, JSONObject params) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(params.toString()))

                    .build();

            response = HttpClient.newBuilder()
                    .build().send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}


