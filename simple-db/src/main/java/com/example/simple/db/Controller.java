package com.example.simple.db;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class Controller {

    private final DataService dataService;

    public Controller(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/")
    public String hello() {
        String message = "<B>Welcome to the sample database!</B><br>";
        message += "While you are here, check out these commands:<br>";
        message += "1. /all => To print all the data<br>";
        message += "2. /Data/{id} => To search id in the data<br>";
        message += "3. /Data/cost/{cost} => To print all the data which are less than the cost<br>";
        return message;
    }

    @GetMapping("/all")
    public List<Data> get() {
        return dataService.get();
    }

    @GetMapping("/Data/{id}")
    public Data get(@PathVariable String id) {
        return dataService.get(id);
    }

    @GetMapping("/Data/cost/{cost}")
    public List<Data> get(@PathVariable double cost) {
        return dataService.getLessThanCost(cost);
    }

    @DeleteMapping("/Data/{id}")
    public List<Data> delete(@PathVariable String id) {
        return dataService.delete(id);
    }
    /* Script file to delete
    (async function deleteItem(id) {
    await fetch('http://localhost:8080/Data/' + id, {method: "DELETE"})
    })("1");
     */
    @PostMapping("/Data")
    public List<Data> create(@RequestBody Data data) {
        data.setId(UUID.randomUUID().toString());
        dataService.add(data);
        return dataService.get();
    }
    /* Script to check on webpage console
        (async function createPhoto() {
  let data = {"item_name": "Guava"};

  await fetch('http://localhost:8080/Data', {
    method: "POST",
    headers: {
        "Accept": "application/json",
        "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(result => result.text())
    .then(text => alert(text));
        })();
     */
}
