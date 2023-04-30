package com.example.first.model;

public class MyRecyclerViewModel {

    String pics;
    String text;

    public MyRecyclerViewModel(String pics, String text) {
        this.pics = pics;
        this.text = text;
    }

    public String getPics() {
        return pics;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
