package com.hanfeng.utils.convert;

import com.hanfeng.pojo.po.CategoryPO;
import com.hanfeng.pojo.vo.CategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    CategoryVO po2Vo(CategoryPO source);

}
