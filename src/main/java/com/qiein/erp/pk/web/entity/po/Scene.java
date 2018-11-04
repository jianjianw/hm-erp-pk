package com.qiein.erp.pk.web.entity.po;

import java.io.Serializable;

public class Scene implements Serializable {
    private static final long serialVersionUID = 8656946036214356631L;

    private Integer id;

    private Integer shootId;

    private String sceneName;

    private Short sceneStatus;

    private Integer priority;

    private Integer companyId;


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