package com.hanfeng.utils.convert;

import com.hanfeng.pojo.bo.ArticleBO;
import com.hanfeng.pojo.po.ArticlePO;
import com.hanfeng.pojo.vo.ArticleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleConverter {

    ArticleConverter INSTANCE = Mappers.getMapper(ArticleConverter.class);

    @Mapping(source = "source.categoryPO.name", target = "categoryName")
    ArticleVO bo2Vo(ArticleBO source);

}
