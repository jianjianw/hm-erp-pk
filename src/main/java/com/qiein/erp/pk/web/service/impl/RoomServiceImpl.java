package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.constant.RoomConstant;
import com.qiein.erp.pk.web.dao.RoomDao;
import com.qiein.erp.pk.web.entity.dto.LevelAndRoomDTO;
import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.entity.vo.RoomSelectVO;
import com.qiein.erp.pk.web.entity.vo.RoomVO;
import com.qiein.erp.pk.web.service.RoomService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 房间   1 化妆间  2 拍摄间
 * author:wang lei
 * date : 2018-11-04
 * */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;
    @Override
    public int deleteByPrimaryKey(Integer roomId,Integer companyId) {
        return roomDao.deleteByPrimaryKey(roomId,companyId);
    }

    @Override
    public int insert(Room room) {
        return roomDao.insert(room);
    }

    @Override
    public Room selectByPrimaryKey(Integer roomId,Integer companyId) {
        return roomDao.selectByPrimaryKey(roomId,companyId);
    }

    @Override
    public List<Room> selectAll(Integer companyId,Integer roomType) {
        return roomDao.selectAll(companyId,roomType);
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
    public RoomVO selectRoomByServiceId(String venueIds,Integer companyId){
        RoomVO roomVO=new RoomVO();
        List<RoomSelectVO> makeupRoom=roomDao.roomSelect(venueIds,1,companyId);
        List<RoomSelectVO> shootRoom=roomDao.roomSelect(venueIds,2,companyId);
        roomVO.setMakeupRoom(makeupRoom);
        roomVO.setShootRoom(shootRoom);
        return roomVO;
    }

    @Override
    public List<Room> findRoomByVenueId(Integer companyId,Integer venueId, Integer roomType) {
        return roomDao.findRoomByVenueId(companyId,venueId,roomType);
    }

    @Override
    public void roomSort(List<Room> rooms) {
        roomDao.roomSort(rooms);
    }

    @Override
    public void roomLevelSort(List<LevelAndRoomDTO> levelAndRoomDTOS) {
        roomDao.roomLevelSort(levelAndRoomDTOS);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRoomLevel(LevelAndRoomDTO levelAndRoomDTO) {

        //添加之前先查询
        String roomType = levelAndRoomDTO.getRoomType();
        if(StringUtils.equals(roomType, RoomConstant.MAKEUP_ROOM)){//化妆间
            levelAndRoomDTO.setRoomLevelType(RoomConstant.MAKEUP_ROOM_LEVEL);
        }
        if(StringUtils.equals(roomType,RoomConstant.SHOOT_ROOM)){//拍摄间
            levelAndRoomDTO.setRoomLevelType(RoomConstant.SHOOT_ROOM_LEVEL);
        }
        //添加分类
        roomDao.addRoomLevel(levelAndRoomDTO);
        //添加房间
        List<Room> rooms = levelAndRoomDTO.getRooms();
        if(rooms != null && rooms.size()>0){
            roomDao.batAddRoom(rooms);
        }
    }

    @Override
    public void batAddRoom(List<Room> rooms) {
        roomDao.batAddRoom(rooms);
    }

    @Override
    public void batInsertOrUpdate(List<Room> rooms) {

        for(Room room : rooms){
            Room room1 = roomDao.selectByPrimaryKey(room.getRoomId(), room.getCompanyId());
            if(room1 == null){
                roomDao.insert(room);
            }else{
                roomDao.updateByPrimaryKey(room);
            }
        }

       //这个方法不行
        // roomDao.batInsertOrUpdate(rooms);
    }

    @Override
    public void batUpdateRoom(List<Room> rooms) {
        roomDao.batUpdateRoom(rooms);
    }

    @Override
    public void updateRoomLevel(LevelAndRoomDTO levelAndRoomDTO) {
        roomDao.updateRoomLevel(levelAndRoomDTO);
    }

    @Override
    public List<LevelAndRoomDTO> findRoomLevel(Integer companyId,String roomType) {
        return roomDao.findRoomLevel(companyId,roomType);
    }

    @Override
    public void batUpdateRoomLevel(List<LevelAndRoomDTO> levelAndRoomDTOs) {
        roomDao.batUpdateRoomLevel(levelAndRoomDTOs);
    }


}
