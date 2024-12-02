package com.hanfeng.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.hanfeng.pojo.po.ArticlePO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanfeng
* @description 针对表【h_article(文章表)】的数据库操作Mapper
* @createDate 2024-11-19 02:12:13
* @Entity com.hanfeng.domain.ArticlePo
*/

@Mapper
public interface ArticleMapper extends MPJBaseMapper<ArticlePO> {

}




