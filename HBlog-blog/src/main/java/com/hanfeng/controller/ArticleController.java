package com.hanfeng.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hanfeng.pojo.bo.ArticleBO;
import com.hanfeng.pojo.dto.ArticleDetailDTO;
import com.hanfeng.pojo.po.ArticlePO;
import com.hanfeng.pojo.vo.ArticleDetailVO;
import com.hanfeng.pojo.vo.ArticleVO;
import com.hanfeng.pojo.vo.HotArticleVO;
import com.hanfeng.pojo.vo.PageVO;
import com.hanfeng.service.ArticleService;
import com.hanfeng.utils.MybatisSearchUtil;
import com.hanfeng.utils.ResponseResult;
import com.hanfeng.utils.convert.ArticleConverter;
import com.hanfeng.utils.convert.ArticleDetailConverter;
import com.hanfeng.utils.convert.HotArticleConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
@Api(tags = "文章")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articleList")
    @ApiOperation("查询文章列表 (分页)")
    public ResponseResult<PageVO<ArticleVO>> getArticleList(@RequestParam("pageNum") Integer pageNum,
                                                            @RequestParam("pageSize") Integer pageSize,
                                                            @RequestParam("categoryId") Long categoryId) {
        IPage<ArticleBO> articlePOPage = articleService.getArticleList(pageNum, pageSize, categoryId);
        PageVO<ArticleVO> articlePageVO = MybatisSearchUtil.pageDataTransType(articlePOPage, ArticleConverter.INSTANCE::bo2Vo);
        return ResponseResult.success(articlePageVO);
    }

    @GetMapping("/hotArticleList")
    @ApiOperation("查询热门文章列表")
    public ResponseResult<List<HotArticleVO>> hotArticleList() {
        List<ArticlePO> articlePOS = articleService.hotArticleList();
        List<HotArticleVO> hotArticleVOS = articlePOS.stream()
                .map(HotArticleConverter.INSTANCE::po2Vo)
                .toList();
        return ResponseResult.success(hotArticleVOS);
    }

    @PostMapping("/detail")
    @ApiOperation("查询文章详情")
    public ResponseResult<ArticleDetailVO> getArticleDetail(@RequestBody ArticleDetailDTO articleDetailDTO) {
        Long articleId = articleDetailDTO.getArticleId();
        ArticleBO articleBO = articleService.getArticleDetail(articleId);
        ArticleDetailConverter instance = ArticleDetailConverter.INSTANCE;
        ArticleDetailVO articleDetailVO = instance.bo2Vo(articleBO);
        return ResponseResult.success(articleDetailVO);
    }

}
