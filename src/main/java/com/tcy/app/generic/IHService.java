package com.tcy.app.generic;

import com.tcy.app.result.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 80002023 on 2016/6/3.
 */
public interface IHService<T, ID extends Serializable> {

    /**
     * @param record
     * @return
     */
    T saveOrUpdate(T record);

    List<T> saveOrUpdate(List<T> records);

    /**
     * @param id
     * @return
     */
    T find(ID id);

    void delete(ID id);

    void delete(List<T> records);

    List<T> findAll();

    /**
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult<T> findPage(T record, int pageNum, int pageSize);
}
