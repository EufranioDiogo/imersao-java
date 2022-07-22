package com.uijacode.models.http.services.responses;

import com.uijacode.models.Movie;

import java.util.List;

public class ImdbResponseBody {
    private List<Movie> items;

    public ImdbResponseBody() {
    }

    public ImdbResponseBody(List<Movie> items) {
        this.items = items;
    }

    public List<Movie> getItems() {
        return items;
    }

    public void setItems(List<Movie> items) {
        this.items = items;
    }
}
