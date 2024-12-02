package com.hanfeng.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("分类名")
    private String name;
}
