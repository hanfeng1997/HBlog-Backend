package com.hanfeng.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "热门文章类")
public class HotArticleVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章访问量")
    private Long viewCount;

}
