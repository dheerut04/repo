package com.example.simple.db;

public class Data {
    private String id;
    private String item_name;

    private double cost;

    public Data(){

    }
    public Data(String id, String item_name, double cost) {
        this.id = id;
        this.item_name = item_name;
        this.cost = cost;
    }


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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


}
