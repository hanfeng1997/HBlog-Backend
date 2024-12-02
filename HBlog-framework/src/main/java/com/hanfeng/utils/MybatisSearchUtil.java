package com.hanfeng.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanfeng.pojo.vo.PageVO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class MybatisSearchUtil {

    /**
     * page中的数据类型转换
     * @param pageData
     * @param function
     * @return
     * @param <T>
     * @param <R>
     */
    public static <T, R> PageVO<R> pageDataTransType(IPage<T> pageData, Function<T, R> function) {
        List<R> collect = pageData.getRecords().stream().map(function).collect(Collectors.toList());
        return new PageVO<>(collect, pageData.getTotal());
    }

}
