package com.hanfeng.controller;

import com.hanfeng.pojo.po.LinkPO;
import com.hanfeng.pojo.vo.LinkVO;
import com.hanfeng.service.LinkService;
import com.hanfeng.utils.ResponseResult;
import com.hanfeng.utils.convert.LinkConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/link")
@Api(tags = "友链")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/getAllLink")
    @ApiOperation("查询所有友链")
    public ResponseResult<List<LinkVO>> getAllLink() {
        List<LinkPO> linkPOS = linkService.getAllLink();
        List<LinkVO> linkVOS = linkPOS.stream()
                .map(LinkConverter.INSTANCE::po2Vo)
                .toList();
        return ResponseResult.success(linkVOS);
    }


}
