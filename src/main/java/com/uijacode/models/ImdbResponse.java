package com.uijacode.models;

import java.io.Serializable;
import java.util.List;

public class ImdbResponse implements Serializable {
    private List<Movie> items;

    public ImdbResponse() {
    }

    public ImdbResponse(List<Movie> items) {
        this.items = items;
    }

    public List<Movie> getItems() {
        return items;
    }

    public void setItems(List<Movie> items) {
        this.items = items;
    }
}
