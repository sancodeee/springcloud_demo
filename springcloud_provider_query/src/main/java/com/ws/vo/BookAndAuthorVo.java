package com.ws.vo;

import com.ws.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAndAuthorVo {

    private Integer id;

    private String name;

    private String type;

    private String description;

    private Author author;

}
