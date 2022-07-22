package com.uijacode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.uijacode.image.manager.StrickerGenerator;
import com.uijacode.models.ImdbResponse;
import com.uijacode.models.Movie;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URL;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        * 1. Fazer uma conexão HTTP
        * 2. Pegar os dados do IMDB
        * 3. Parsear os dados (title, poster, rating)
        * 4. Guardar os dados já parseados em um estrutura
        * */
        final String URL =  "https://imdb-api.com/en/API/Top250Movies/k_aso84k4s";
        URI uri = URI.create(URL);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

        try {
            HttpResponse<String> send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JsonParser jsonParser = new JsonParser();

            ObjectMapper objectMapper = new ObjectMapper();
            Gson g = new Gson();

            System.out.println(send.body().substring(0, 100));

            ImdbResponse mapOfMovies = g.fromJson(send.body(), ImdbResponse.class);

            mapOfMovies.getItems().stream().limit(2).forEach(movie -> {
                try {
                    InputStream inputStream = new URL(movie.getImage()).openStream();
                    StrickerGenerator.create(inputStream, movie.getTitle());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
