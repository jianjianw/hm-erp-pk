package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Room;

import java.util.List;

public interface RoomDao {
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    Room selectByPrimaryKey(Integer roomId);

    List<Room> selectAll();

    int updateByPrimaryKey(Room record);
}