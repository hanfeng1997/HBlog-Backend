package com.hanfeng.service;

import com.hanfeng.pojo.po.CategoryPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hanfeng
* @description 针对表【h_category(分类表)】的数据库操作Service
* @createDate 2024-12-01 20:12:58
*/
public interface CategoryService extends IService<CategoryPO> {

    List<CategoryPO> getCategoryList();
}
