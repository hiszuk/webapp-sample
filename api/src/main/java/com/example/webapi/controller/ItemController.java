package com.example.webapi.controller;

import java.util.List;

import com.example.webapi.entity.Item;
import com.example.webapi.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin
public class ItemController {

    @Autowired 
    private ItemService itemService;

    @GetMapping(value = "/items")
    public List<Item> selectAll() {
        return itemService.selectAll();
    }

    @GetMapping(value = "/item/{id}")
    public Item selectByKey(@PathVariable int id) {
        return itemService.selectByKey( id );
    }

    @PutMapping(value = "/item/{id}")
    public void updateByKey(@PathVariable int id, @RequestBody Item item) {
        item.setId(id);
        itemService.updateByKey(item);
    }

    @DeleteMapping(value = "/item/{id}")
    public void deleteByKey(@PathVariable int id) {
        itemService.deleteByKey(id);
    }

    @PostMapping(value = "/item")
    public int createNew(@RequestBody Item item) {
        return itemService.createNew(item);
    }

}