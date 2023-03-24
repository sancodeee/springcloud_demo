package com.ws.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "作者")
@TableName(value = "author")
public class Author {

    @ApiModelProperty(value = "id")
    @TableField(value = "id")
    private Integer id;

    @ApiModelProperty(value = "作者名字")
    @TableField(value = "author")
    private String name;


}
