package com.qiein.erp.pk.web.service;

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
    List<RoomSelectVO> selectRoomByServiceId(String venueIds, Integer companyId, Integer type);

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
}
