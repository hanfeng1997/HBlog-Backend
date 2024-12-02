package com.hanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanfeng.constants.LinkConstant;
import com.hanfeng.pojo.po.LinkPO;
import com.hanfeng.service.LinkService;
import com.hanfeng.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanfeng
 * @description 针对表【h_link(友链)】的数据库操作Service实现
 * @createDate 2024-12-02 01:59:31
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, LinkPO> implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<LinkPO> getAllLink() {
        LambdaQueryWrapper<LinkPO> wrapper = Wrappers.lambdaQuery(LinkPO.class)
                .eq(LinkPO::getStatus, LinkConstant.LINK_STATUS_NORMAL);
        List<LinkPO> linkPOS = linkMapper.selectList(wrapper);
        return linkPOS;
    }
}

