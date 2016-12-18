package com.cs.a;

/**
 * Created by 举 on 2016/12/14.
 */
public class Provice {
    private int id;

    private String name;

    public Provice(){

    }

    public Provice(int id,String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
