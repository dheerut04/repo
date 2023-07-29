package com.example.simple.db;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {
    private List<Data> db = new ArrayList<>();

    public DataService() {
        db.add(new Data("1", "Apple", 200));
        db.add(new Data("2", "Oranges", 150));
        db.add(new Data("3", "Kiwi", 300));
    }

    public List<Data> get() {
        return db;
    }

    public Data get(String id) {
        return db.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Data> getLessThanCost(double cost) {
        return db.stream()
                .filter(data -> data.getCost() < cost)
                .collect(Collectors.toList());
    }

    public List<Data> delete(String id) {
        db.removeIf(data -> data.getId().equals(id));
        return db;
    }

    public void add(Data data) {
        db.add(data);
    }
}
