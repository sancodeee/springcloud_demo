package com.ws.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "作者")
@TableName(value = "author")
public class Author {

    @ApiModelProperty(value = "作者id")
    @TableField(value = "id")
    private Integer id;

    @ApiModelProperty(value = "作者姓名")
    @TableField(value = "author")
    private String author ;

}
