package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.constant.RoomConstant;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.LevelAndRoomDTO;
import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.service.RoomService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 房间   1 化妆间  2 拍摄间
 * author:wang lei
 * date : 2018-11-04
 * */
@RestController
@RequestMapping("/room")
public class RoomController {

    Integer companyId = 1 ;

    @Autowired
    private RoomService roomService;

    @PostMapping("/delete_by_primary_key")
    public ResultInfo deleteByPrimaryKey(Integer roomId){
        int i = roomService.deleteByPrimaryKey(roomId,companyId);
        return ResultInfoUtil.success();
    }

    /**
     * 添加房间
     * @param room
     * @return
     */
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Room room){
        int insert = roomService.insert(room);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_by_primary_key")
    public ResultInfo selectByPrimaryKey(Integer roomId){//id已经确定了是化妆间还是拍摄间。
        Room room = roomService.selectByPrimaryKey(roomId,companyId);
        return ResultInfoUtil.success(room);
    }
    @GetMapping("/select_all")
    public ResultInfo selectAll(Integer roomType){
        List<Room> rooms = roomService.selectAll(companyId,roomType);
        return ResultInfoUtil.success(rooms);
    }


    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody Room record){
        int i = roomService.updateByPrimaryKey(record);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_room_for_service")
    public ResultInfo selectRoomForService(@RequestParam String venueIds){
        return ResultInfoUtil.success(roomService.selectRoomByServiceId(venueIds,companyId));
    }


    //查询场馆下面的化妆间 1 或者 拍摄间 2
    @GetMapping("/find_room_by_venue_id")
    public ResultInfo findRoomByVenueId(Integer venueId, Integer roomType){
        List<Room> rooms = roomService.findRoomByVenueId(companyId, venueId, roomType);
        return ResultInfoUtil.success(rooms);
    }


    //化妆间排序 1  或  拍摄间排序 2
    @PostMapping("/room_sort")
    public ResultInfo roomSort(@RequestBody List<Room> rooms){
        roomService.roomSort(rooms);
        return ResultInfoUtil.success();
    }

    @PostMapping("/room_level_sort")
    public ResultInfo roomLevelSort(@RequestBody List<LevelAndRoomDTO> levelAndRoomDTOS){
        roomService.roomLevelSort(levelAndRoomDTOS);
        return ResultInfoUtil.success();
    }

    //排序前 先查询所有的数据
    @GetMapping("get_all_room_and_type")
    public ResultInfo getLevelAndRoom(Integer companyId,Integer venueId,String roomType){

        if(StringUtils.equals(roomType, RoomConstant.MAKEUP_ROOM)){//化妆间
            roomType = RoomConstant.MAKEUP_ROOM_LEVEL;
        }
        if(StringUtils.equals(roomType,RoomConstant.SHOOT_ROOM)){//拍摄间
            roomType = RoomConstant.SHOOT_ROOM_LEVEL;
        }
        List<LevelAndRoomDTO> list = roomService.getLevelAndRoom(companyId,venueId,roomType);
        return ResultInfoUtil.success(list);
    }

    //添加分类(化妆间)  添加到字典表
    @PostMapping("/add_room_type")
    public ResultInfo addRoomLevel(@RequestBody LevelAndRoomDTO levelAndRoomDTO){
        roomService.addRoomLevel(levelAndRoomDTO);
        return ResultInfoUtil.success();
    }

    //批量编辑
    @PostMapping("/bat_insert_or_update")
    public ResultInfo batInsertOrUpdate(@RequestBody List<Room> rooms){
        roomService.batInsertOrUpdate(rooms);
        return ResultInfoUtil.success();
    }


}
