package com.hanfeng.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 友链
 */
@TableName(value ="h_link")
@Data
public class LinkPO {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("id")
    private Long id;

    @TableField(value = "name")
    @ApiModelProperty("友链名称")
    private String name;

    @TableField(value = "logo")
    @ApiModelProperty("logo")
    private String logo;

    @TableField(value = "description")
    @ApiModelProperty("描述")
    private String description;

    @TableField(value = "address")
    @ApiModelProperty("网址")
    private String address;

    @TableField(value = "status")
    @ApiModelProperty("审核状态 (0代表审核通过，1代表审核未通过，2代表未审核)")
    private String status;

    @TableField(value = "create_by")
    @ApiModelProperty("创建人")
    private Long createBy;

    @TableField(value = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField(value = "update_by")
    @ApiModelProperty("更新人")
    private Long updateBy;

    @TableField(value = "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    @TableField(value = "del_flag")
    @ApiModelProperty("删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;

}