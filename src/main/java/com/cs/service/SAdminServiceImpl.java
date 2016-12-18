package com.cs.service;

import com.cs.bean.SAdmin;
import com.cs.common.bean.Pager4EasyUI;
import com.cs.dao.SAdminDAO;
import com.cs.dao.SAdminDAOImpl;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 举 on 2016/12/6.
 */
public class SAdminServiceImpl implements SAdminService {

    private SAdminDAO sAdminDAO;

    public SAdminDAO getsAdminDAO() {
        return sAdminDAO;
    }

    public void setsAdminDAO(SAdminDAO sAdminDAO) {
        this.sAdminDAO = sAdminDAO;
    }

    @Override
    public SAdmin save(SAdmin sAdmin) {
        return sAdminDAO.save(sAdmin);
    }

    @Override
    public void delete(SAdmin sAdmin) {
        sAdminDAO.delete(sAdmin);
    }

    @Override
    public void update(SAdmin sAdmin) {
        sAdminDAO.update(sAdmin);
    }

    @Override
    public SAdmin queryById(Class<?> clazz, Serializable id) {
        return sAdminDAO.queryById(clazz, id);
    }

    @Override
    public Pager4EasyUI<SAdmin> queryByPager(String beanName, Pager4EasyUI<SAdmin> pager) {
        return sAdminDAO.queryByPager(beanName, pager);
    }

    @Override
    public long count(String beanName) {
        return sAdminDAO.count(beanName);
    }

    @Override
    public List<SAdmin> queryByEmailPwd(SAdmin sAdmin) {
        return sAdminDAO.queryEmailPwd(sAdmin);
    }
}
