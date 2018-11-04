package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(Integer roomId){
        int i = roomService.deleteByPrimaryKey(roomId);
        return i;
    }
    @PostMapping("/insert")
    public int insert(Room room){
        int insert = roomService.insert(room);
        return insert;
    }
    @GetMapping("/selectByPrimaryKey")
    public Room selectByPrimaryKey(Integer roomId){
        Room room = roomService.selectByPrimaryKey(roomId);
        return room;
    }
    @GetMapping("/selectAll")
    public List<Room> selectAll(){
        List<Room> rooms = roomService.selectAll();
        return rooms;
    }
    @PostMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(Room record){
        int i = roomService.updateByPrimaryKey(record);
        return i;
    }
}
