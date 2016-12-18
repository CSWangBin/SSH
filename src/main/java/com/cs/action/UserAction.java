package com.cs.action;

import com.cs.bean.User;
import com.cs.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 举 on 2016/12/13.
 */
public class UserAction extends ActionSupport {
    private UserService userService;
    private User user;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String queryById() {
        user = userService.queryById(User.class,"adasdasfgsgsfdgeesrg");
        System.out.println(user);
        return "query";
    }
}
