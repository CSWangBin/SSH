package com.cs.dao;

import com.cs.bean.SAdmin;
import com.cs.bean.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * Created by 举 on 2016/11/29.
 */
public class SAdminDAOImpl extends AbstractBaseDAO<SAdmin> implements SAdminDAO{

    /**
     * 登录验证
     */
    public List<SAdmin> queryEmailPwd(SAdmin sAdmin) {
        List<SAdmin> list=null;
        try{
            String hql ="from SAdmin as s where s.email=? and s.password=?";
            list= (List<SAdmin>) getHibernateTemplate().find(hql, new String[]{sAdmin.getEmail(),sAdmin.getPassword()});
        }catch(RuntimeException ex){
            logger.error("find by property name failed", ex);
        }
        return list;
    }


}
