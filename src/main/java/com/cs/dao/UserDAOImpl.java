package com.cs.dao;

import com.cs.bean.User;
import com.cs.common.bean.Pager4EasyUI;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by 举 on 2016/12/13.
 */
public class UserDAOImpl  extends AbstractBaseDAO<User> implements UserDAO {

}
