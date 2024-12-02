package com.hanfeng.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanfeng.pojo.bo.ArticleBO;
import com.hanfeng.pojo.po.ArticlePO;

import java.util.List;

/**
* @author hanfeng
* @description 针对表【h_article(文章表)】的数据库操作Service
* @createDate 2024-11-19 02:12:13
*/
public interface ArticleService extends IService<ArticlePO> {

    /**
     * 文章列表 (分页)
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<ArticleBO> getArticleList(Integer pageNum, Integer pageSize, Long categoryId);

    /**
     * 热门文章列表
     * @return
     */
    List<ArticlePO> hotArticleList();

    /**
     * 文章详情
     * @param id
     * @return
     */
    ArticleBO getArticleDetail(Long id);
}
