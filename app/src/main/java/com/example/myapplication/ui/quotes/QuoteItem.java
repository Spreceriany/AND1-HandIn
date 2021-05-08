package com.example.myapplication.ui.quotes;

public class QuoteItem {
    private int imageResource;
    private String quote;
    private String name;

    public QuoteItem(int imageResource, String quote, String name) {
        this.imageResource = imageResource;
        this.quote = quote;
        this.name = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getQuote() {
        return quote;
    }

    public String getQuoteName() {
        return name;
    }
}
