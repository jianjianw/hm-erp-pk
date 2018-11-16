package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

/***
 * 场景
 * author:wang lei
 * date : 2018-11-04
 */
public class ScenePO implements Serializable {
    private static final long serialVersionUID = 8656946036214356631L;

    private Integer id;     //场景id

    private Integer shootId;    //拍摄间id

    private String sceneName;  //场景名字

    private Short sceneStatus;  //场景状态  1 开启  0 关闭

    private Integer priority;   //排序

    private Integer companyId;  //公司id


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShootId() {
        return shootId;
    }

    public void setShootId(Integer shootId) {
        this.shootId = shootId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName == null ? null : sceneName.trim();
    }

    public Short getSceneStatus() {
        return sceneStatus;
    }

    public void setSceneStatus(Short sceneStatus) {
        this.sceneStatus = sceneStatus;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}