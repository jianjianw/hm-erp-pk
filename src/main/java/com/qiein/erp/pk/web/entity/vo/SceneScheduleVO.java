package com.qiein.erp.pk.web.entity.vo;

/**
 * 拍摄景 档期
 * wang lei
 * 2018-11-16
 */
public class SceneScheduleVO {


    private Integer id;             //拍摄间档期id

    private Integer shootId;    //拍摄间id

    private Integer sceneId;        //场景id

    private String sceneName;       //拍摄景name

    private Integer startTime;  //开始时间戳

    private Integer endTime;    //结束时间戳


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

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
