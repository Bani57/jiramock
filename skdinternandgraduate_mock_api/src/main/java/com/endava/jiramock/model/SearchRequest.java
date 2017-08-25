package com.endava.jiramock.model;

public class SearchRequest {
    private String value;

    public SearchRequest() {
    }

    public SearchRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
