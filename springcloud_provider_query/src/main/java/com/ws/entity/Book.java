package com.ws.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "书籍")
@TableName(value = "book")
public class Book {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "书名")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "书籍类型")
    @TableField(value = "type")
    private String type;

    @ApiModelProperty(value = "书籍描述")
    @TableField(value = "description")
    private String description;

    @ApiModelProperty(value = "书籍作者编号")
    @TableField(value = "book_author")
    private Integer bookAuthor;

}
