package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.constant.RoomConstant;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.LevelAndRoomDTO;
import com.qiein.erp.pk.web.entity.po.Room;
import com.qiein.erp.pk.web.service.RoomService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "添加房间")
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Room room){
        roomService.insert(room);
        return ResultInfoUtil.success();
    }
    @ApiOperation(value = "根据主键查询房间")
    @GetMapping("/select_by_primary_key")
    public ResultInfo selectByPrimaryKey(Integer roomId){//id已经确定了是化妆间还是拍摄间。
        Room room = roomService.selectByPrimaryKey(roomId,companyId);
        return ResultInfoUtil.success(room);
    }
    @ApiOperation(value = "根据主键查询房间")
    @ApiImplicitParam(name = "roomType",value = "房间类型  化妆间:1 拍摄间:2 ", dataType = "Integer")
    @GetMapping("/select_all")
    public ResultInfo selectAll(Integer roomType){
        List<Room> rooms = roomService.selectAll(companyId,roomType);
        return ResultInfoUtil.success(rooms);
    }

    @ApiOperation(value = "根据主键编辑房间")
    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody Room room){
        int i = roomService.updateByPrimaryKey(room);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_room_for_service")
    public ResultInfo selectRoomForService(@RequestParam String venueIds){
        return ResultInfoUtil.success(roomService.selectRoomByServiceId(venueIds,companyId));
    }

    @ApiOperation(value = "查询场馆下面的拍摄间或者房间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "venueId",value = "场馆id", dataType = "Integer"),
            @ApiImplicitParam(name = "roomType",value = "房间类型(化妆间：1 拍摄间：2)",dataType = "Integer")
    })
    //查询场馆下面的化妆间 1 或者 拍摄间 2
    @GetMapping("/find_room_by_venue_id")
    public ResultInfo findRoomByVenueId(Integer venueId, Integer roomType){
        List<Room> rooms = roomService.findRoomByVenueId(companyId, venueId, roomType);
        return ResultInfoUtil.success(rooms);
    }

    @ApiOperation(value = "化妆间或者房间排序")
    //化妆间排序 1  或  拍摄间排序 2
    @PostMapping("/room_sort")
    public ResultInfo roomSort(@RequestBody List<Room> rooms){
        roomService.roomSort(rooms);
        return ResultInfoUtil.success();
    }

    @ApiOperation(value = "化妆间等级或者房间等级排序")
    @PostMapping("/room_level_sort")
    public ResultInfo roomLevelSort(@RequestBody List<LevelAndRoomDTO> levelAndRoomDTOS){
        roomService.roomLevelSort(levelAndRoomDTOS);
        return ResultInfoUtil.success();
    }

    //排序前 先查询所有的数据
    @ApiOperation(value = "查询房间等级 和 下面的房间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "venueId",value = "场馆id", dataType = "Integer"),
            @ApiImplicitParam(name = "roomType",value = "房间类型(化妆间：1 拍摄间：2)",dataType = "Integer")
    })
    @GetMapping("get_all_room_and_type")
    public ResultInfo getLevelAndRoom(Integer venueId,String roomType){

        //查询所有房间
        List<Room> rooms = roomService.findRoomByVenueId(companyId, venueId, Integer.valueOf(roomType));

        if(StringUtils.equals(roomType, RoomConstant.MAKEUP_ROOM)){//化妆间
            roomType = RoomConstant.MAKEUP_ROOM_LEVEL;
        }
        if(StringUtils.equals(roomType,RoomConstant.SHOOT_ROOM)){//拍摄间
            roomType = RoomConstant.SHOOT_ROOM_LEVEL;
        }
        //查询所有等级
        List<LevelAndRoomDTO> list =  roomService.findRoomLevel(companyId,roomType);

        //封装房间到等级
        for(LevelAndRoomDTO levelAndRoomDTO : list){
            Integer roomLevelCode = levelAndRoomDTO.getRoomLevelCode();
            for(Room room : rooms){
                Integer roomLevel = room.getRoomLevel();
                if(roomLevelCode.equals(roomLevel)){
                    levelAndRoomDTO.getRooms().add(room);
                }
            }
        }
        return ResultInfoUtil.success(list);
    }

    //添加分类(化妆间)  添加到字典表
    @ApiOperation(value = "添加房间等级和房间")
    @PostMapping("/add_room_type")
    public ResultInfo addRoomLevel(@RequestBody LevelAndRoomDTO levelAndRoomDTO){
        roomService.addRoomLevel(levelAndRoomDTO);
        return ResultInfoUtil.success();
    }

    //批量添加房间
    @ApiOperation(value = "批量添加房间")
    @PostMapping("/bat_add_room")
    public ResultInfo batAddRoom(@RequestBody List<Room> rooms){
        roomService.batAddRoom(rooms);
        return ResultInfoUtil.success();
    }


    //批量编辑和新增
    @ApiOperation(value = "批量添加和编辑房间")
    @PostMapping("/bat_insert_or_update")
    public ResultInfo batInsertOrUpdate(@RequestBody List<Room> rooms){
        roomService.batInsertOrUpdate(rooms);
        return ResultInfoUtil.success();
    }

    /**
     * 批量更新房间
     */
    @ApiOperation(value = "批量编辑房间")
    @PostMapping("/bat_update_room")
    public ResultInfo batUpdateRoom(@RequestBody List<Room> rooms){
        roomService.batUpdateRoom(rooms);
        return ResultInfoUtil.success();
    }

    @ApiOperation(value = "修改房间等级")
    @PostMapping("/update_room_type")
    public ResultInfo updateRoomLevel(@RequestBody LevelAndRoomDTO levelAndRoomDTO){
        if(StringUtils.equals(levelAndRoomDTO.getRoomType(), RoomConstant.MAKEUP_ROOM)){//化妆间
            levelAndRoomDTO.setRoomLevelType(RoomConstant.MAKEUP_ROOM_LEVEL);
        }
        if(StringUtils.equals(levelAndRoomDTO.getRoomType(),RoomConstant.SHOOT_ROOM)){//拍摄间
            levelAndRoomDTO.setRoomLevelType(RoomConstant.SHOOT_ROOM_LEVEL);
        }
        roomService.updateRoomLevel(levelAndRoomDTO);
        return ResultInfoUtil.success();
    }

    @ApiOperation(value = "批量修改房间等级")
    @PostMapping("/bat_update_room_type")
    public ResultInfo batUpdateRoomLevel(@RequestBody List<LevelAndRoomDTO> levelAndRoomDTOs){

        for(LevelAndRoomDTO levelAndRoomDTO : levelAndRoomDTOs){
            if(StringUtils.equals(levelAndRoomDTO.getRoomType(), RoomConstant.MAKEUP_ROOM)){//化妆间
                levelAndRoomDTO.setRoomLevelType(RoomConstant.MAKEUP_ROOM_LEVEL);
            }
            if(StringUtils.equals(levelAndRoomDTO.getRoomType(),RoomConstant.SHOOT_ROOM)){//拍摄间
                levelAndRoomDTO.setRoomLevelType(RoomConstant.SHOOT_ROOM_LEVEL);
            }
        }
        roomService.batUpdateRoomLevel(levelAndRoomDTOs);
        return ResultInfoUtil.success();
    }


}
