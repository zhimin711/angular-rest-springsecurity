package com.tcy.app.result;

import com.tcy.sys.entity.SysUser;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by 80002023 on 2016/6/6.
 */
public class PageResult<T> {

    public int status;
    public List<T> records;
    public int pageNum = 1;
    public int pageSize = 10;
    public long total;
    public int totalPage;

    public PageResult() {
    }

    public PageResult(Page<T> page) {

        this.totalPage = page.getTotalPages();
        this.total = page.getTotalElements();
        this.records = page.getContent();
    }


    public PageResult(Page<T> page, int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = page.getTotalPages();
        this.total = page.getTotalElements();
        this.records = page.getContent();
    }
}
