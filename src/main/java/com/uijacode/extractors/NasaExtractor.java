package com.uijacode.extractors;

import com.google.gson.Gson;
import com.uijacode.models.Content;
import com.uijacode.models.http.services.responses.NasaResponseBody;
import com.uijacode.models.http.services.responses.NasaResponseElement;

import java.util.List;
import java.util.stream.Collectors;

public class NasaExtractor<T> implements Extractor<Content> {
    @Override
    public List<Content> parseData(String JSON_BODY) {
        Gson g = new Gson();

        NasaResponseBody nasaResponseBodyList = g.fromJson(JSON_BODY, NasaResponseBody.class);


        return nasaResponseBodyList
                .getNasaResponseElements()
                .stream()
                .map(nasaResponseElement -> {
                    System.out.println(nasaResponseElement);

                    return nasaResponseElement.getContent();
                })
                .collect(Collectors.toList());
    }
}
