package com.hanfeng.controller;

import com.hanfeng.pojo.po.CategoryPO;
import com.hanfeng.pojo.vo.CategoryVO;
import com.hanfeng.service.CategoryService;
import com.hanfeng.utils.ResponseResult;
import com.hanfeng.utils.convert.CategoryConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(tags = "分类")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    @ApiOperation("查询文章分类列表")
    public ResponseResult<List<CategoryVO>> getCategoryList() {
        List<CategoryPO> categoryPOS = categoryService.getCategoryList();
        List<CategoryVO> categoryVOS = categoryPOS.stream()
                .map(CategoryConverter.INSTANCE::po2Vo)
                .toList();
        return ResponseResult.success(categoryVOS);
    }

}
