package com.example.webapi.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String content;
    private String status;
}
