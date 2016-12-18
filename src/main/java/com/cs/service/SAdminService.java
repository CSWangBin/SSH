package com.cs.service;


import com.cs.bean.SAdmin;

import java.util.List;

/**
 * Created by 举 on 2016/12/6.
 */
public interface SAdminService extends BaseService<SAdmin> {

    /**
     * 登录验证
     * @return
     */
    public List<SAdmin> queryByEmailPwd(SAdmin sAdmin);


}
