package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.RoomDao;
import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.entity.vo.RoomVO;
import com.qiein.erp.pk.web.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;
    @Override
    public int deleteByPrimaryKey(Integer roomId) {
        return roomDao.deleteByPrimaryKey(roomId);
    }

    @Override
    public int insert(Room room) {
        return roomDao.insert(room);
    }

    @Override
    public Room selectByPrimaryKey(Integer roomId) {
        return roomDao.selectByPrimaryKey(roomId);
    }

    @Override
    public List<Room> selectAll() {
        return roomDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Room room) {
        return roomDao.updateByPrimaryKey(room);
    }
    /**
     * 获取下拉框
     * @param venueIds
     * @return
     */
    public RoomVO selectRoomByServiceId(String venueIds){
        RoomVO roomVO=new RoomVO();
        roomVO.setMakeupRoom(roomDao.selectMakeupRoomByServiceId(venueIds));
        roomVO.setShootRoom(roomDao.selectShootRoomByServiceId(venueIds));
        return roomVO;
    }
}
