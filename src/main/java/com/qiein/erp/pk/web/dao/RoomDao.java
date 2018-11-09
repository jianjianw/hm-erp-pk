package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.dto.LevelAndRoomDTO;
import com.qiein.erp.pk.web.entity.po.Room;
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

    int insert(Room room);

    Room selectByPrimaryKey(@Param("roomId") Integer roomId,@Param("companyId")Integer companyId);

    List<Room> selectAll(@Param("companyId")Integer companyId,@Param("roomType")Integer roomType);

    int updateByPrimaryKey(Room room);

    List<RoomSelectVO> roomSelect(@Param("venueIds") String venueIds,@Param("type") Integer type,@Param("companyId") Integer companyId);


    List<Room> findRoomByVenueId(@Param("companyId") Integer companyId, @Param("venueId")Integer venueId,
                                 @Param("roomType")Integer roomType);

    void roomSort(List<Room> rooms);

    void roomLevelSort(List<LevelAndRoomDTO> levelAndRoomDTOS);

    //添加房间等级
    void addRoomLevel(LevelAndRoomDTO levelAndRoomDTO);
    //批量添加房间
    void batAddRoom(List<Room> rooms);

    /**
     * 获取房间等级 和 房间
     */
    List<LevelAndRoomDTO> getLevelAndRoom(@Param("companyId") Integer companyId,
                                                 @Param("venueId") Integer venueId,
                                                 @Param("roomType") String roomType);


    /**
     * 获取等级下面的房间
     */
    List<LevelAndRoomDTO> findRoomByLevelId(@Param("companyId") Integer companyId,
                                                      @Param("venueId") Integer venueId,
                                                      @Param("levelId") Integer levelId);

    /**
     * 批量编辑房间
     * @param rooms
     */
    void batUpdateRoom(List<Room> rooms);
}