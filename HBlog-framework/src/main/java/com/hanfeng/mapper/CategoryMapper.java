package com.hanfeng.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.hanfeng.pojo.po.CategoryPO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanfeng
* @description 针对表【h_category(分类表)】的数据库操作Mapper
* @createDate 2024-12-01 20:12:58
* @Entity com.hanfeng.pojo.po.CategoryPO
*/

@Mapper
public interface CategoryMapper extends MPJBaseMapper<CategoryPO> {

}




