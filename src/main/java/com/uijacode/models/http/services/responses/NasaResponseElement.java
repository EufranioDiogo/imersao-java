package com.uijacode.models.http.services.responses;

import com.uijacode.models.Content;

public class NasaResponseElement {
    private String title;
    private String url;
    private String explanation;


    public NasaResponseElement() {
    }

    public NasaResponseElement(String title, String url, String explanation) {
        this.title = title;
        this.url = url;
        this.explanation = explanation;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getExplanation() {
        return explanation;
    }

    public Content getContent() {
        return new Content(this.title, this.url);
    }
}
