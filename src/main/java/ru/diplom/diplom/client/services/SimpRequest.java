package ru.diplom.diplom.client.services;

import java.io.*;
import java.net.*;
import java.net.http.*;
import org.json.*;

public class SimpRequest {

    public static HttpResponse<String> get(String url) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()

                    .build();

            response = HttpClient.newBuilder()
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

    public static HttpResponse<String> post(String url, JSONObject params) {
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .POST(HttpRequest.BodyPublishers.ofString(params.toString()))
//                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
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


