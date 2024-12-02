package com.hanfeng.utils.convert;

import com.hanfeng.pojo.po.LinkPO;
import com.hanfeng.pojo.vo.LinkVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LinkConverter {

    LinkConverter INSTANCE = Mappers.getMapper(LinkConverter.class);

    LinkVO po2Vo(LinkPO source);

}
