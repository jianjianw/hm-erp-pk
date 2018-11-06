package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomDao {
    int deleteByPrimaryKey(@Param("roomId")Integer roomId,@Param("companyId")Integer companyId);

    int insert(Room room);

    Room selectByPrimaryKey(@Param("roomId") Integer roomId,@Param("companyId")Integer companyId);

    List<Room> selectAll(@Param("companyId")Integer companyId);

    int updateByPrimaryKey(Room room);

    List<Room> selectMakeupRoomByServiceId(@Param("venueIds") String venueIds);

    List<Room> selectShootRoomByServiceId(@Param("venueIds") String venueIds);
}