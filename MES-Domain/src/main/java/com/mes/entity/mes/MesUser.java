package com.mes.entity.mes;

/**
 * MES 用户表
 * Created by wanshan.hu on 2017/6/21.
 */
public class MesUser {

    private Long id;

    private String name;

    private String data;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
