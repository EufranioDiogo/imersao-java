package com.uijacode.models.http.services.responses;

import com.uijacode.models.Content;

import java.util.List;

public class NasaResponseBody {
    List<NasaResponseElement> nasaResponseElements;

    public NasaResponseBody(List<NasaResponseElement> nasaResponseElements) {
        this.nasaResponseElements = nasaResponseElements;
    }

    public List<NasaResponseElement> getNasaResponseElements() {
        return nasaResponseElements;
    }
}
