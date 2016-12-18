package com.cs.action;

import com.cs.bean.SAdmin;

import com.cs.common.bean.ControllerResult;
import com.cs.common.bean.Pager4EasyUI;
import com.cs.service.SAdminService;
import com.cs.service.SAdminServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 举 on 2016/12/6.
 */
public class SAdminAction extends ActionSupport implements ServletRequestAware, SessionAware {
    private Map session;
    private String status;
    private SAdminService sAdminService;
    private SAdmin sAdmin;
    private long total;
    private List<SAdmin> rows;
    private ControllerResult result;
    private String email;
    private String pwd;
    private String a;
    private String b;

    private String id;
    private HttpServletRequest req;

    public void setsAdminService(SAdminService sAdminService) {
        this.sAdminService = sAdminService;
    }

    public Map getSession() {
        return session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public SAdmin getsAdmin() {
        return sAdmin;
    }

    public void setsAdmin(SAdmin sAdmin) {
        this.sAdmin = sAdmin;
    }

    public ControllerResult getResult() {
        return result;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public long getTotal() {
        return total;
    }

    public List<SAdmin> getRows() {
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
     * 登录验证
     * @return
     */
    public String checking() {
        List<SAdmin> list = sAdminService.queryByEmailPwd(sAdmin);
        for (SAdmin s : list) {
            if (s != null) {
                a = s.getName();
                b = s.getRole();
                return "home";
            };
        }
        return "input";
    }


    /**
     * 添加管理员
     * @return
     */
    public String add() {
        System.out.println(sAdmin.getName());
        System.out.println();

        if(sAdmin.getStatus()==null){
            sAdmin.setStatus("Y");
        }
        sAdminService.save(sAdmin);

        result = ControllerResult.getSuccessResult("添加成功");
        return "add";
    }


    /**
     * 根据id查询管理员
     * @return
     */
    public String queryById() {
        sAdminService.queryById(SAdmin.class, id);

        return "query";
    }


    /**
     * 分页查询管理员
     * @return
     */
    public String queryAll() {
        String pageNoStr = req.getParameter("page");
        String pageSizeStr = req.getParameter("rows");
        Pager4EasyUI<SAdmin> pager = new Pager4EasyUI<SAdmin>();
        if (pageNoStr != null) {
            pager.setPageNo(Integer.valueOf(pageNoStr));
            pager.setPageSize(Integer.valueOf(pageSizeStr));
        }
        pager = sAdminService.queryByPager("SAdmin", pager);
        pager.setTotal(sAdminService.count("SAdmin"));
        rows = pager.getRows();
        total = pager.getTotal();
        return "all";

    }

    /**
     * 修改管理员
     * @return
     */
    public String update() {
        sAdminService.update(sAdmin);
        result = ControllerResult.getSuccessResult("修改成功");
        return "update";
    }


    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public String outSession() {
        HttpSession session = req.getSession();
        session.removeAttribute("sAdmin");
        return "out";
    }
}
