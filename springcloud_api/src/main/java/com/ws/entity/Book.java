package com.ws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Book implements Serializable {

    private static final long serialVersionUID = 8860959639291393111L;

    private Integer id;

    private String name;

    private String type;

    private String description;

    private String bookAuthor;

}
