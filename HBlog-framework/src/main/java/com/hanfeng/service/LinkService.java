package com.hanfeng.service;

import com.hanfeng.pojo.po.LinkPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hanfeng
* @description 针对表【h_link(友链)】的数据库操作Service
* @createDate 2024-12-02 01:59:31
*/
public interface LinkService extends IService<LinkPO> {

    /**
     * 查询所有友链
     *
     * @return
     */
    List<LinkPO> getAllLink();
}
