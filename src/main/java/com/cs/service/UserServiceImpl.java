package com.cs.service;

import com.cs.bean.User;
import com.cs.common.bean.Pager4EasyUI;
import com.cs.dao.UserDAO;

import java.io.Serializable;

/**
 * Created by 举 on 2016/12/13.
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public User queryById(Class<?> clazz, Serializable id) {
        return userDAO.queryById(clazz, id);
    }

    @Override
    public Pager4EasyUI<User> queryByPager(String beanName, Pager4EasyUI<User> pager) {
        return userDAO.queryByPager(beanName, pager);
    }

    @Override
    public long count(String beanName) {
        return userDAO.count(beanName);
    }
}
