package com.hanfeng.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 分类表
 */
@Data
@TableName(value ="h_category")
@ApiModel("分类实体类")
public class CategoryPO {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    @TableField(value = "name")
    @ApiModelProperty("分类名")
    private String name;

    @TableField(value = "pid")
    @ApiModelProperty("父分类id，如果没有父分类为-1")
    private Long pid;

    @TableField(value = "description")
    @ApiModelProperty("描述")
    private String description;

    @TableField(value = "status")
    @ApiModelProperty("状态0:正常,1禁用")
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