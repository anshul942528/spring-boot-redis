package com.ansh.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {

    private int id;

    private String name;

    private String category;
}