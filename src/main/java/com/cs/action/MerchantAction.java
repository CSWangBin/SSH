package com.cs.action;

import com.cs.bean.Merchant;

import com.cs.bean.SAdmin;
import com.cs.common.bean.ControllerResult;
import com.cs.common.bean.Pager4EasyUI;
import com.cs.service.MerchantService;
import com.cs.service.MerchantServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 举 on 2016/12/6.
 */
public class MerchantAction extends ActionSupport implements ServletRequestAware {
    private String status;
    private MerchantService merchantService;
    private Merchant merchant;
    private long total;
    private List<Merchant> rows;
    private ControllerResult result;

    private String id;
    private HttpServletRequest req;


    public void setMerchantService(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public ControllerResult getResult() {
        return result;
    }

    public long getTotal() {
        return total;
    }

    public List<Merchant> getRows() {
        return rows;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setServletRequest(HttpServletRequest req) {
        this.req = req;
    }

    /**
     * 店长登录
     */
    public String checking() {
        return "login";
    }

    /**
     * 添加店长
     * @return
     */
    public String add() {
        if(merchant.getStatus()==null){
            merchant.setStatus("Y");
        }
        merchantService.save(merchant);

        result = ControllerResult.getSuccessResult("添加成功");
        return "add";
    }


    /**
     * 根据id查询店长
     * @return
     */
    public String queryById() {
        merchantService.queryById(Merchant.class, id);
        return "query";
    }


    /**
     * 分页查询店长
     * @return
     */
    public String queryAll() {
        String pageNoStr = req.getParameter("page");
        String pageSizeStr = req.getParameter("rows");
        Pager4EasyUI<Merchant> pager = new Pager4EasyUI<Merchant>();
        if (pageNoStr != null) {
            pager.setPageNo(Integer.valueOf(pageNoStr));
            pager.setPageSize(Integer.valueOf(pageSizeStr));
        }
        pager = merchantService.queryByPager("Merchant", pager);
        pager.setTotal(merchantService.count("Merchant"));
        rows = pager.getRows();
        total = pager.getTotal();
        return "all";

    }

    /**
     * 修改店长
     * @return
     */
    public String update() {
        System.out.println("Aaaaaaaaaaaaaaaaaaaa");
        System.out.println(merchant + "bbb");
        merchantService.update(merchant);
        result = ControllerResult.getSuccessResult("修改成功");
        return "update";
    }


}
