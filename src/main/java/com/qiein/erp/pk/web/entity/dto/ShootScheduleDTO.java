package com.qiein.erp.pk.web.entity.dto;

import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import com.qiein.erp.pk.web.entity.po.VenueRoomScenePO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 拍摄景档期
 * wang lei
 * 2018-11-9
 */
public class ShootScheduleDTO implements Serializable {
    private static final long serialVersionUID = 1652695696837736403L;

    //所有拍摄景(表头)
    private List<VenueRoomScenePO> venueRoomScenePOS;
    //拍摄档期
    private List<SceneScheduleDTO> sceneScheduleDTO;



    public List<VenueRoomScenePO> getVenueRoomScenePOS() {
        return venueRoomScenePOS;
    }

    public void setVenueRoomScenePOS(List<VenueRoomScenePO> venueRoomScenePOS) {
        this.venueRoomScenePOS = venueRoomScenePOS;
    }

    public List<SceneScheduleDTO> getSceneScheduleDTO() {
        return sceneScheduleDTO;
    }

    public void setSceneScheduleDTO(List<SceneScheduleDTO> sceneScheduleDTO) {
        this.sceneScheduleDTO = sceneScheduleDTO;
    }

}
