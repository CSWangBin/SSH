package com.cs.dao;

import com.cs.bean.SAdmin;
import com.cs.bean.User;

import java.util.List;

/**
 * Created by 举 on 2016/11/29.
 */
public interface SAdminDAO extends BaseDAO<SAdmin> {
    /**
     * 登录验证
     * @return
     */
    public List<SAdmin> queryEmailPwd(SAdmin sAdmin);

}
