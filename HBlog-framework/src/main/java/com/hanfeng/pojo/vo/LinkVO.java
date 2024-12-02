package com.hanfeng.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("友链VO")
public class LinkVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("友链名称")
    private String name;

    @ApiModelProperty("logo")
    private String logo;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("网址")
    private String address;

}
