package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.entity.vo.RoomVO;

import java.util.List;

public interface RoomService {

    int deleteByPrimaryKey(Integer roomId);

    int insert(Room room);

    Room selectByPrimaryKey(Integer roomId);

    List<Room> selectAll();

    int updateByPrimaryKey(Room room);

    /**
     * 获取下拉框
     * @param venueIds
     * @return
     */
    RoomVO selectRoomByServiceId(String venueIds);
}
