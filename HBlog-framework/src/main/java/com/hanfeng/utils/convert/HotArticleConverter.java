package com.hanfeng.utils.convert;

import com.hanfeng.pojo.po.ArticlePO;
import com.hanfeng.pojo.vo.HotArticleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotArticleConverter {

    HotArticleConverter INSTANCE = Mappers.getMapper(HotArticleConverter.class);

    HotArticleVO po2Vo(ArticlePO source);
}
