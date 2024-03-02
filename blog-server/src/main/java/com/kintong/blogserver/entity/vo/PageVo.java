package com.kintong.blogserver.entity.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kintong.blogserver.commons.consts.Const;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * @Author kintong
 */


@Slf4j
@Data
public class PageVo<T> {

    @JSONField(name = Const.PAGE_TOTAL_NAME)
    @JsonProperty(Const.PAGE_TOTAL_NAME)
    private long total = 0;


    @JSONField(name = Const.PAGE_RECORDS_NAME)
    @JsonProperty(Const.PAGE_RECORDS_NAME)
    private List<T> records = Collections.emptyList();

    @JSONField(name = Const.PAGE_INDEX_NAME)
    @JsonProperty(Const.PAGE_INDEX_NAME)
    private Long pageIndex;


    @JSONField(name = Const.PAGE_SIZE_NAME)
    @JsonProperty(Const.PAGE_SIZE_NAME)
    private Long pageSize;

    public PageVo() {

    }

    public PageVo(IPage<T> page) {
        this.total = page.getTotal();
        this.records = page.getRecords();
        this.pageIndex = page.getCurrent();
        this.pageSize = page.getSize();
    }


}
