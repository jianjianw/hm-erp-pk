package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Room;

import java.util.List;

public interface RoomService {

    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    Room selectByPrimaryKey(Integer roomId);

    List<Room> selectAll();

    int updateByPrimaryKey(Room record);
}
