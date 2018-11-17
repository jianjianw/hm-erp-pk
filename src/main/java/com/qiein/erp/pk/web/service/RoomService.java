package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.LevelAndRoomDTO;
import com.qiein.erp.pk.web.entity.po.RoomPO;
import com.qiein.erp.pk.web.entity.vo.RoomVO;

import java.util.List;
/**
 * 房间   1 化妆间  2 拍摄间
 * author:wang lei
 * date : 2018-11-04
 * */
public interface RoomService {

    int deleteByPrimaryKey(Integer roomId,Integer companyId);

    int insert(RoomPO roomPO);

    RoomPO selectByPrimaryKey(Integer roomId, Integer companyId);

    List<RoomPO> selectAll(Integer companyId, Integer roomType);

    int updateByPrimaryKey(RoomPO roomPO);

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
    List<RoomPO> findRoomByVenueId(Integer companyId, Integer venueId, Integer roomType);

    /**
     * 化妆间 拍摄间排序
     * @param roomPOS
     */
    void roomSort(List<RoomPO> roomPOS);

    /**
     * 房间分类排序
     * @param
     */
    void roomLevelSort(List<LevelAndRoomDTO> levelAndRoomDTOS);

    /**
     * 添加房间等级
     * @param levelAndRoomDTO
     */
    void addRoomLevel(LevelAndRoomDTO levelAndRoomDTO);

    //批量添加房间
    void batAddRoom(List<RoomPO> roomPOS);

    /**
     * 批量新增或更新
     * @param roomPOS
     */
    void batInsertOrUpdate(List<RoomPO> roomPOS);

    /**
     * 批量编辑房间
     */
    void batUpdateRoom(List<RoomPO> roomPOS);

    /**
     * 修改房间等级
     * @param levelAndRoomDTO
     */
    void updateRoomLevel(LevelAndRoomDTO levelAndRoomDTO);

    /**
     * 查询房间等级
     * @param roomType
     * @return
     */
    List<LevelAndRoomDTO> findRoomLevel(Integer companyId,String roomType);

    /**
     * 批量修改房间等级
     * @param levelAndRoomDTOs
     */
    void batUpdateRoomLevel(List<LevelAndRoomDTO> levelAndRoomDTOs);

}
