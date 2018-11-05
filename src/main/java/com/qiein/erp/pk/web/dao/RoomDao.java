package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomDao {
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room room);

    Room selectByPrimaryKey(Integer roomId);

    List<Room> selectAll();

    int updateByPrimaryKey(Room room);

    List<Room> selectMakeupRoomByServiceId(@Param("venueIds") String venueIds);

    List<Room> selectShootRoomByServiceId(@Param("venueIds") String venueIds);
}