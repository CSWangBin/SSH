package com.cs.service;

import com.cs.bean.Merchant;
import com.cs.common.bean.Pager4EasyUI;
import com.cs.dao.BaseDAO;
import com.cs.dao.MerchantDAO;
import com.cs.dao.MerchantDAOImpl;

import java.io.Serializable;

/**
 * Created by 举 on 2016/12/9.
 */
public class MerchantServiceImpl implements MerchantService {

    private MerchantDAO merchantDAO;

    public MerchantDAO getMerchantDAO() {
        return merchantDAO;
    }

    public void setMerchantDAO(MerchantDAO merchantDAO) {
        this.merchantDAO = merchantDAO;
    }

    @Override
    public Merchant save(Merchant merchant) {
        return merchantDAO.save(merchant);
    }

    @Override
    public void delete(Merchant merchant) {
        merchantDAO.delete(merchant);
    }

    @Override
    public void update(Merchant merchant) {
        merchantDAO.update(merchant);
    }

    @Override
    public Merchant queryById(Class<?> clazz, Serializable id) {
        return merchantDAO.queryById(clazz, id);
    }

    @Override
    public Pager4EasyUI<Merchant> queryByPager(String beanName, Pager4EasyUI<Merchant> pager) {
        return merchantDAO.queryByPager(beanName, pager);
    }

    @Override
    public long count(String beanName) {
        return merchantDAO.count(beanName);
    }
}
