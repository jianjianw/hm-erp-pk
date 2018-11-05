package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 房间   1 化妆间  2 拍摄间
 * */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/deleteByPrimaryKey")
    public ResultInfo deleteByPrimaryKey(Integer roomId){
        int i = roomService.deleteByPrimaryKey(roomId);
        return ResultInfoUtil.success();
    }
    @PostMapping("/insert")
    public ResultInfo insert(Room room){
        int insert = roomService.insert(room);
        return ResultInfoUtil.success();
    }
    @GetMapping("/selectByPrimaryKey")
    public ResultInfo selectByPrimaryKey(Integer roomId){
        Room room = roomService.selectByPrimaryKey(roomId);
        return ResultInfoUtil.success(room);
    }
    @GetMapping("/selectAll")
    public ResultInfo selectAll(){
        List<Room> rooms = roomService.selectAll();
        return ResultInfoUtil.success(rooms);
    }
    @PostMapping("/updateByPrimaryKey")
    public ResultInfo updateByPrimaryKey(Room record){
        int i = roomService.updateByPrimaryKey(record);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_room_by_service_id")
    public ResultInfo selectMakeupRoomByServiceId(String venueIds){
        return ResultInfoUtil.success(roomService.selectRoomByServiceId(venueIds));
    }

}
