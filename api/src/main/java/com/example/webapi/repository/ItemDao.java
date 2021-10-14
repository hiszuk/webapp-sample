package com.example.webapi.repository;

import java.util.List;

import com.example.webapi.entity.Item;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemDao {

    List<Item> selectAll();
    
    Item selectByKey(int id);
    
    void updateByKey(Item item);
    
    void deleteByKey(int id);

    void createNew(Item item);
}