package com.example.market;

public class market {

    private String id;

    private String item_name;

    public market() {

    }

    public market(String id, String item_name) {
        this.id = id;
        this.item_name = item_name;
    }

    // Raw Data such as Images e.t.c
    // ALT+Insert

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
