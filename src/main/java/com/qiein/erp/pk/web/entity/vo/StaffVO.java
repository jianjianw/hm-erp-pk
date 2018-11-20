package com.qiein.erp.pk.web.entity.vo;

import java.io.Serializable;

/*
* 员工vo
* */
public class StaffVO implements Serializable {
    private static final long serialVersionUID = 478409900156363957L;

    private Integer id; //员工id

    private String nickName;//员工name

    private Boolean flag;//是否可选


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
