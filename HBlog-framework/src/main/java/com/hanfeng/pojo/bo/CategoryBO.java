package com.hanfeng.pojo.bo;

import com.hanfeng.pojo.po.ArticlePO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryBO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty("分类名")
    private String name;

    @ApiModelProperty("父分类id，如果没有父分类为-1")
    private Long pid;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("状态0:正常,1禁用")
    private String status;

    @ApiModelProperty("文章实体类")
    private ArticlePO article;

}
