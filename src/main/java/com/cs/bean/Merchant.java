package com.cs.bean;

import java.sql.Timestamp;

/**
 * Created by 举 on 2016/12/9.
 */
public class Merchant {
    private String id;
    private String user;
    private String name;
    private String password;
    private String gender; //性别
    private String grade; //等级
    private String superior_id; //上级id
    private String identity_card; //身份证号码
    private String bank_card; //银行卡号码
    private String bank_type; //银行卡类型
    private String we_char; //微信
    private String family_address; //家庭住址
    private String phone; //手机号码
    private Timestamp create_time; //创建时间
    private Timestamp last_login_time; //最后一次登录时间
    private String Status; //状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSuperior_id() {
        return superior_id;
    }

    public void setSuperior_id(String superior_id) {
        this.superior_id = superior_id;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public String getBank_card() {
        return bank_card;
    }

    public void setBank_card(String bank_card) {
        this.bank_card = bank_card;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getWe_char() {
        return we_char;
    }

    public void setWe_char(String we_char) {
        this.we_char = we_char;
    }

    public String getFamily_address() {
        return family_address;
    }

    public void setFamily_address(String family_address) {
        this.family_address = family_address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Timestamp last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                ", superior_id='" + superior_id + '\'' +
                ", identity_card='" + identity_card + '\'' +
                ", bank_card='" + bank_card + '\'' +
                ", bank_type='" + bank_type + '\'' +
                ", we_char='" + we_char + '\'' +
                ", family_address='" + family_address + '\'' +
                ", phone='" + phone + '\'' +
                ", create_time=" + create_time +
                ", last_login_time=" + last_login_time +
                ", Status='" + Status + '\'' +
                '}';
    }
}
