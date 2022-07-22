package com.uijacode.extractors;

import com.google.gson.Gson;
import com.uijacode.models.Content;
import com.uijacode.models.Movie;
import com.uijacode.models.http.services.responses.ImdbResponseBody;

import java.util.List;
import java.util.stream.Collectors;

public class ImdbExtractor<T> implements Extractor<Content> {
    @Override
    public List<Content> parseData(String JSON_BODY) {
        Gson g = new Gson();

        ImdbResponseBody nasaResponseBodyList = g.fromJson(JSON_BODY, ImdbResponseBody.class);


        return nasaResponseBodyList.getItems().stream().map(Movie::getContent).collect(Collectors.toList());
    }
}
