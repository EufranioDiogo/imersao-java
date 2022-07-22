package com.uijacode.extractors;

import java.util.List;

public interface Extractor<T> {
    List<T> parseData(String JSON_BODY);
}
