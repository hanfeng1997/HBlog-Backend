package com.hanfeng.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ArticleDetailDTO {

    @ApiModelProperty("文章id")
    private Long articleId;

}
