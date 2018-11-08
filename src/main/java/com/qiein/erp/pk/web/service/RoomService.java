package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.LevelAndRoomDTO;
import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.entity.vo.RoomSelectVO;
import com.qiein.erp.pk.web.entity.vo.RoomVO;

import java.util.List;
/**
 * 房间   1 化妆间  2 拍摄间
 * author:wang lei
 * date : 2018-11-04
 * */
public interface RoomService {

    int deleteByPrimaryKey(Integer roomId,Integer companyId);

    int insert(Room room);

    Room selectByPrimaryKey(Integer roomId,Integer companyId);

    List<Room> selectAll(Integer companyId,Integer roomType);

    int updateByPrimaryKey(Room room);

    /**
     * 获取下拉框
     * @param venueIds
     * @return
     */
    RoomVO selectRoomByServiceId(String venueIds, Integer companyId);

    /**
     * 查询场馆下面的 化妆间 或 房间
     * @param companyId
     * @param venueId
     * @param roomType
     * @return
     */
    List<Room> findRoomByVenueId(Integer companyId,Integer venueId, Integer roomType);

    /**
     * 化妆间 拍摄间排序
     * @param rooms
     */
    void roomSort(List<Room> rooms);

    /**
     * 房间分类排序
     * @param
     */
    void roomLevelSort(List<LevelAndRoomDTO> levelAndRoomDTOS);

    /**
     * 获取等级 和 房间
     * */
    List<LevelAndRoomDTO> getLevelAndRoom(Integer companyId, Integer venueId, String roomType);

    /**
     * 添加房间等级
     * @param levelAndRoomDTO
     */
    void addRoomLevel(LevelAndRoomDTO levelAndRoomDTO);

    //批量添加房间
    void batAddRoom(List<Room> rooms);


    /**
     * 批量编辑或者更新
     * @param rooms
     */
    void batInsertOrUpdate(List<Room> rooms);


}
