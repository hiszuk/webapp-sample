package com.example.webapi.service;

import java.util.List;

import com.example.webapi.entity.Item;
import com.example.webapi.repository.ItemDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ItemService {

    @Autowired
    private ItemDao itemMapper;

    @Transactional
    public List<Item> selectAll() {
        return itemMapper.selectAll();
    }

    @Transactional
    public Item selectByKey(int id) {
        return itemMapper.selectByKey( id );
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, readOnly = false)
    public void updateByKey(Item item) {
        itemMapper.updateByKey( item );
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteByKey(int id) {
        itemMapper.deleteByKey( id );
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, readOnly = false)
    public int createNew(Item item) {
        itemMapper.createNew( item );
        return item.getId();
    }

}