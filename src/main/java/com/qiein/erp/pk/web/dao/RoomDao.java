package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.dto.LevelAndRoomDTO;
import com.qiein.erp.pk.web.entity.po.RoomPO;
import com.qiein.erp.pk.web.entity.vo.RoomSelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 房间   1 化妆间  2 拍摄间
 * author:wang lei
 * date : 2018-11-04
 * */
public interface RoomDao {
    int deleteByPrimaryKey(@Param("roomId")Integer roomId,@Param("companyId")Integer companyId);

    int insert(RoomPO roomPO);

    RoomPO selectByPrimaryKey(@Param("roomId") Integer roomId, @Param("companyId")Integer companyId);

    List<RoomPO> selectAll(@Param("companyId")Integer companyId, @Param("roomType")Integer roomType);

    int updateByPrimaryKey(RoomPO roomPO);

    List<RoomSelectVO> roomSelect(@Param("venueIds") String venueIds,@Param("type") Integer type,@Param("companyId") Integer companyId);


    List<RoomPO> findRoomByVenueId(@Param("companyId") Integer companyId, @Param("venueId")Integer venueId,
                                   @Param("roomType")Integer roomType);

    void roomSort(List<RoomPO> roomPOS);

    void roomLevelSort(List<LevelAndRoomDTO> levelAndRoomDTOS);

    //添加房间等级
    void addRoomLevel(LevelAndRoomDTO levelAndRoomDTO);
    //批量添加房间
    void batAddRoom(List<RoomPO> roomPOS);

    /**
     * 获取等级下面的房间
     */
    List<LevelAndRoomDTO> findRoomByLevelId(@Param("companyId") Integer companyId,
                                                      @Param("venueId") Integer venueId,
                                                      @Param("levelId") Integer levelId);

    /**
     * 批量编辑房间
     * @param roomPOS
     */
    void batUpdateRoom(List<RoomPO> roomPOS);

    /**
     * 批量编辑和新增
     * @param roomPOS
     */
    void batInsertOrUpdate(List<RoomPO> roomPOS);

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
    List<LevelAndRoomDTO> findRoomLevel(@Param("companyId") Integer companyId,@Param("roomType")String roomType);

    /**
     * 批量编辑房间
     * @param levelAndRoomDTOs
     */
    void batUpdateRoomLevel(List<LevelAndRoomDTO> levelAndRoomDTOs);

    /**
     * 查询场馆下面房间的个数
     * @param companyId
     * @param venueId
     * @param roomType
     * @param status
     * @return
     */
    Integer findRoomCount(@Param("companyId")Integer companyId,
                          @Param("venueId") Integer venueId,
                          @Param("roomType") Integer roomType,
                          @Param("status") Integer status);

    /**
     * 名字查重
     * @param roomPO
     * @return
     */
    String checkName(RoomPO roomPO);
}