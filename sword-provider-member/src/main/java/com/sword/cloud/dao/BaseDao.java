package com.sword.cloud.dao;

import java.util.List;

/**
 *@description:
 *
 *@author Sjh
 *@date 2019/1/19 10:18
 *@version 1.0.1
 */
public interface BaseDao<T> {

    public Integer add(T t);

    public T findById(Long id);

    public List<T> findAll();

    public List<T> findByCondition();

    public Integer del(T t);

    public Integer edit(T t);
}
