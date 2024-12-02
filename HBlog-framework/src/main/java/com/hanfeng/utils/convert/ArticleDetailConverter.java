package com.hanfeng.utils.convert;

import com.hanfeng.pojo.bo.ArticleBO;
import com.hanfeng.pojo.vo.ArticleDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleDetailConverter {

    ArticleDetailConverter INSTANCE = Mappers.getMapper(ArticleDetailConverter.class);

    @Mapping(source = "source.categoryPO.name", target = "categoryName")
    ArticleDetailVO bo2Vo(ArticleBO source);

}
