package com.cs.dao;

import com.cs.common.bean.Pager4EasyUI;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by 举 on 2016/12/13.
 */
public abstract class AbstractBaseDAO<T> extends HibernateDaoSupport implements BaseDAO<T> {
    public T save(T t) {
        this.getHibernateTemplate().save(t);
        return t;
    }

    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @SuppressWarnings("unchecked")
    public T queryById(Class<?> clazz, Serializable id) {

        return (T) this.getHibernateTemplate().load(clazz, id);
    }

    public Pager4EasyUI<T> queryByPager(String beanName, Pager4EasyUI<T> pager) {
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from " + beanName);
        query.setFirstResult(pager.getBeginIndex());
        query.setMaxResults(pager.getPageSize());
        List<T> list = (List<T>) query.list();
        pager.setRows(list);
        return pager;
    }

    public long count(String beanName) {
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("select count(*) from " + beanName);
//        SQLQuery sqlQuery = session.createSQLQuery("select count(*) from " + beanName);
        Long aLong = (long) query.uniqueResult();
        return aLong;
    }
}
