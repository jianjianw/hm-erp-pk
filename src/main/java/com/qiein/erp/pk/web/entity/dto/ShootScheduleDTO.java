package com.qiein.erp.pk.web.entity.dto;

import com.qiein.erp.pk.web.entity.po.Scene;

import java.io.Serializable;
import java.util.List;

/**
 * 拍摄景档期
 * wang lei
 * 2018-11-9
 */
public class ShootScheduleDTO implements Serializable {
    private static final long serialVersionUID = 1652695696837736403L;

    //所有拍摄景
    private List<Scene> scenes;
    //拍摄档期
    private List<TimeStampScheduleDTO>  timeStampScheduleDTOS;


    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public List<TimeStampScheduleDTO> getTimeStampScheduleDTOS() {
        return timeStampScheduleDTOS;
    }

    public void setTimeStampScheduleDTOS(List<TimeStampScheduleDTO> timeStampScheduleDTOS) {
        this.timeStampScheduleDTOS = timeStampScheduleDTOS;
    }
}
