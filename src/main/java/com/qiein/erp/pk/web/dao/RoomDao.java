package com.qiein.erp.pk.web.dao;

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

}