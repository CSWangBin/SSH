package com.cs.service;

import com.cs.common.bean.Pager4EasyUI;

import java.io.Serializable;

/**
 * Created by 举 on 2016/12/13.
 */
public interface BaseService<T> {
    public T save(T t);

    public void delete(T t);

    public void update(T t);

    public T queryById(Class<?> clazz, Serializable id);

    public Pager4EasyUI<T> queryByPager(String beanName, Pager4EasyUI<T> pager);

    public long count(String beanName);
}
