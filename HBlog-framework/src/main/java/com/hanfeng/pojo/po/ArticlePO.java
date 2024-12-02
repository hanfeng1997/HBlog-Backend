package com.hanfeng.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文章表
 */
@Data
@TableName(value ="h_article")
@ApiModel(value = "文章实体类")
public class ArticlePO {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    @TableField(value = "title")
    @ApiModelProperty(value = "标题")
    private String title;

    @TableField(value = "content")
    @ApiModelProperty(value = "文章内容")
    private String content;

    @TableField(value = "summary")
    @ApiModelProperty(value = "文章摘要")
    private String summary;

    @TableField(value = "category_id")
    @ApiModelProperty(value = "所属分类id")
    private Long categoryId;

    @TableField(value = "thumbnail")
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;

    @TableField(value = "is_top")
    @ApiModelProperty(value = "是否置顶（0否，1是）")
    private String isTop;

    @TableField(value = "status")
    @ApiModelProperty(value = "状态（1已发布，0草稿）")
    private String status;

    @TableField(value = "view_count")
    @ApiModelProperty(value = "访问量")
    private Long viewCount;

    @TableField(value = "is_comment")
    @ApiModelProperty(value = "是否允许评论 1是，0否")
    private String isComment;

    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建人")
    private Long createBy;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField(value = "update_by")
    @ApiModelProperty(value = "更新人")
    private Long updateBy;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;

}