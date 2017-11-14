package com.example.administrator.app232_bundle;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/20.
 */

public class Person implements Serializable {
    private Integer id;
    private String name;
    private String passwd;
    private String gender;

    Person(String name,String passwd,String gender){
        this.name=name;
        this.passwd=passwd;
        this.gender=gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
