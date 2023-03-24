package com.ws.entity;

import lombok.Data;

@Data
public class Book {

    private Integer id;
    private String name;
    private String type;
    private String description;
    private Integer bookAuthor;

}
