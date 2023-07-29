package com.example.simple.db;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    List<Data> db = List.of(
            new Data("1", "Apple", 200),
            new Data("2", "Oranges", 150),
            new Data("3", "Kiwi", 300)
    );
    @GetMapping("/")
    public String hello() {
        String message = "<B>Welcome to the sample database!</B><br>";
        message += "While you are here, check out these commands:<br>";
        message += "1. /all => To print all the data<br>";
        message += "2. /Data/{id} => To search id in the data<br>";
        message += "3. /Data/cost/{cost} => To print all the data which are less than the cost<br>";
        message += "4. /Data/delete/{id} => To delete the product by id<br>";
        return message;
    }


    // Get all the data
    @GetMapping("/all")
    public List<Data> get(){
        return db;
    }
    // Get data by id
    @GetMapping("/Data/{id}")
    public List<Data> get(@PathVariable String id){

        int index = Integer.parseInt(id) - 1;
        if (index >= 0 && index <= db.size()) {
            return Collections.singletonList(db.get(Integer.parseInt(String.valueOf(index))));
        }
        /* else {
            // Return an empty list or handle the error as needed
            return Collections.emptyList();
        } */
        return null;
    }
    //filter by cost (it will show all the items which are lower in cost
    @GetMapping("/Data/cost/{cost}")
    public List<Data> get(@PathVariable double cost){
        return db.stream()
                .filter(data -> data.getCost()<cost)
                .collect(Collectors.toList());
    }
    // Delete a specific photo by id
    @DeleteMapping("/Data/delete/{id}")
    public List<Data> Delete(@PathVariable String id){
        int index = Integer.parseInt(id) - 1;
        db.remove(index);
        return db;
    }


}
