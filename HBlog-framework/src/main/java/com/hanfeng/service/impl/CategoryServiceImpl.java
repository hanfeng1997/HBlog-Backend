package com.hanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hanfeng.constants.ArticleConstant;
import com.hanfeng.constants.CategoryConstant;
import com.hanfeng.mapper.ArticleMapper;
import com.hanfeng.pojo.bo.CategoryBO;
import com.hanfeng.pojo.po.ArticlePO;
import com.hanfeng.pojo.po.CategoryPO;
import com.hanfeng.service.CategoryService;
import com.hanfeng.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hanfeng
 * @description 针对表【h_category(分类表)】的数据库操作Service实现
 * @createDate 2024-12-01 20:12:58
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryPO> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<CategoryPO> getCategoryList() {
        // 查询文章表中状态正常的分类id集合
        LambdaQueryWrapper<ArticlePO> articleWrapper = Wrappers.lambdaQuery(ArticlePO.class)
                .eq(ArticlePO::getStatus, ArticleConstant.ARTICLE_STATUS_NORMAL);
        List<ArticlePO> articlePOS = articleMapper.selectList(articleWrapper);
        Set<Long> categoryIds = articlePOS.stream().map(ArticlePO::getCategoryId).collect(Collectors.toSet());

        // 查询分类表中状态正常且有文章的分类集合
        LambdaQueryWrapper<CategoryPO> wrapper = Wrappers.lambdaQuery(CategoryPO.class)
                .eq(CategoryPO::getStatus, CategoryConstant.CATEGORY_STATUS_NORMAL)
                .in(CategoryPO::getId, categoryIds);
        List<CategoryPO> categoryPOS = categoryMapper.selectList(wrapper);

        // MybatisPlusJoin方法 (有缺陷)
//        MPJLambdaWrapper<CategoryPO> wrapper = MPJWrappers.lambdaJoin(CategoryPO.class)
//                .selectAll(CategoryPO.class)
//                .selectAssociation(ArticlePO.class, CategoryBO::getArticle)
//                .leftJoin(ArticlePO.class, ArticlePO::getCategoryId, CategoryPO::getId)
//                .eq(CategoryPO::getStatus, CategoryConstant.CATEGORY_STATUS_NORMAL)
//                .eq(ArticlePO::getStatus, ArticleConstant.ARTICLE_STATUS_NORMAL)
//                ;
//
//        List<CategoryBO> categoryBOS = categoryMapper.selectJoinList(CategoryBO.class, wrapper);
        return categoryPOS;
    }
}




