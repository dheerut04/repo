package com.example.market;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/market")
public class MarketController {

    private List<market> db = List.of(
            new market("1", "Apple" ),
            new market("2", "Orange"),
            new market("3", "Banana")
    );

    @GetMapping("/")
    public String Hello(){

        return "Hello welcome to Market";
    }
    //show all
    @GetMapping("/market")
    public List<market> get(){

        return db;
    }
    //show by ID
    @GetMapping("/market/{id}")
    public market get(@PathVariable String id){

        return db.get(Integer.parseInt(id));
    }
    //creates a new product
    @PostMapping("/market")
    public market post(@PathVariable String id, @PathVariable String itemName){

        market newProduct = new market(id,itemName);
        db.add(newProduct);
        return newProduct;
    }
    //updates an existing product
    @PutMapping("/market/{id}")
    public market put(@PathVariable String id, @PathVariable String itemName){

        market product = db.get(Integer.parseInt(id));
        product.setItem_name(itemName);
        product.setId(id);
        return product;
    }
    //delete the products
    @DeleteMapping("/market/{id}")
    public void delete(@PathVariable String id){

        db.remove(Integer.parseInt(id));
    }



}