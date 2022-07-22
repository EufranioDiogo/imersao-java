package com.uijacode;

import com.google.gson.Gson;
import com.uijacode.extractors.Extractor;
import com.uijacode.extractors.ImdbExtractor;
import com.uijacode.extractors.NasaExtractor;
import com.uijacode.image.manager.StrickerGenerator;
import com.uijacode.models.Content;
import com.uijacode.models.ImdbResponse;
import com.uijacode.services.http.MyHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*
         * 1. Fazer uma conexão HTTP
         * 2. Pegar os dados do IMDB
         * 3. Parsear os dados (title, poster, rating)
         * 4. Guardar os dados já parseados em um estrutura
         * */

        try {
            String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=RcSvwZNY8J8UtF8EnCiBZN82wMiODERg7HKDpgbC&start_date=2022-07-22&end_date=2022-07-22";
            String IMDB_URL = "https://imdb-api.com/en/API/Top250Movies/k_aso84k4s";

            String contentResponseBody = new MyHttpClient().getDataFrom(IMDB_URL);

            Extractor<Content> extractor = new ImdbExtractor<>();
            List<Content> contentList = extractor.parseData(contentResponseBody);
            StrickerGenerator strickerGenerator = new StrickerGenerator(contentList);

            strickerGenerator.generateStickers();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
