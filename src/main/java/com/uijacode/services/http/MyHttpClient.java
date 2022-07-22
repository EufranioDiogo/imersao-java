package com.uijacode.services.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {
    public String getDataFrom(final String URL) throws IOException, InterruptedException {
        URI uri = URI.create(URL);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return send.body();
    }
}
