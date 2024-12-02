package com.hanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hanfeng.constants.ArticleConstant;
import com.hanfeng.mapper.ArticleMapper;
import com.hanfeng.pojo.bo.ArticleBO;
import com.hanfeng.pojo.po.ArticlePO;
import com.hanfeng.pojo.po.CategoryPO;
import com.hanfeng.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
* @author hanfeng
* @description 针对表【h_article(文章表)】的数据库操作Service实现
* @createDate 2024-11-19 02:12:13
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticlePO> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public IPage<ArticleBO> getArticleList(Integer pageNum, Integer pageSize, Long categoryId) {
        MPJLambdaWrapper<ArticlePO> wrapper = MPJWrappers.lambdaJoin(ArticlePO.class)
                .selectAll(ArticlePO.class)
                .selectAssociation(CategoryPO.class, ArticleBO::getCategoryPO)
                .leftJoin(CategoryPO.class, CategoryPO::getId, ArticlePO::getCategoryId)
                .eq(ArticlePO::getStatus, ArticleConstant.ARTICLE_STATUS_NORMAL)
                .eq(Objects.nonNull(categoryId) && categoryId > 0, ArticlePO::getCategoryId, categoryId)
                .orderByDesc(ArticlePO::getIsTop)
                .orderByDesc(ArticlePO::getCreateTime);
        IPage<ArticleBO> page = new Page<>(pageNum, pageSize);
        IPage<ArticleBO> articleBOIPage = articleMapper.selectJoinPage(page, ArticleBO.class, wrapper);

        return articleBOIPage;
    }

    @Override
    public List<ArticlePO> hotArticleList() {
        LambdaQueryWrapper<ArticlePO> wrapper = Wrappers.lambdaQuery(ArticlePO.class)
                .eq(ArticlePO::getStatus, ArticleConstant.ARTICLE_STATUS_NORMAL)
                .orderByDesc(ArticlePO::getViewCount);
        Page<ArticlePO> page = new Page<>(1, 10);
        Page<ArticlePO> articlePOPage = articleMapper.selectPage(page, wrapper);

        return articlePOPage.getRecords();
    }

    @Override
    public ArticleBO getArticleDetail(Long id) {
        MPJLambdaWrapper<ArticlePO> wrapper = MPJWrappers.lambdaJoin(ArticlePO.class)
                .selectAssociation(CategoryPO.class, ArticleBO::getCategoryPO)
                .leftJoin(CategoryPO.class, CategoryPO::getId, ArticlePO::getCategoryId)
                .eq(ArticlePO::getId, id);
        ArticleBO articleBO = articleMapper.selectJoinOne(ArticleBO.class, wrapper);
        return articleBO;
    }
}




