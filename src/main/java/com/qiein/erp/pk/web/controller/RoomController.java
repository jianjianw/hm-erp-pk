package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.constant.RoomConstant;
import com.qiein.erp.pk.util.ObjectUtil;
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
public class RoomController extends InitController{


    @Autowired
    private RoomService roomService;

    @PostMapping("/delete_by_primary_key")
    public ResultInfo deleteByPrimaryKey(Integer roomId){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        roomService.deleteByPrimaryKey(roomId,companyId);
        return ResultInfoUtil.success();
    }

    /**
     * 添加房间
     * @param room
     * @return
     */
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Room room){
        //去掉对象中的空格
        ObjectUtil.objectStrParamTrim(room);
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        room.setCompanyId(companyId);
        roomService.insert(room);
        return ResultInfoUtil.success();
    }
    /**
     * 根据主键查询房间
     */
    @GetMapping("/select_by_primary_key")
    public ResultInfo selectByPrimaryKey(Integer roomId){//id已经确定了是化妆间还是拍摄间。
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        Room room = roomService.selectByPrimaryKey(roomId,companyId);
        return ResultInfoUtil.success(room);
    }

    /**
     * 根据房间类型查询房间
     * @param roomType
     * @return
     */
    @GetMapping("/select_all")
    public ResultInfo selectAll(Integer roomType){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<Room> rooms = roomService.selectAll(companyId,roomType);
        return ResultInfoUtil.success(rooms);
    }

    /**
     * 根据主键编辑房间
     * @param room
     * @return
     */
    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody Room room){

        Integer companyId=getCurrentLoginStaff().getCompanyId();
        room.setCompanyId(companyId);
        //去掉对象中的空格
        ObjectUtil.objectStrParamTrim(room);
        roomService.updateByPrimaryKey(room);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_room_for_service")
    public ResultInfo selectRoomForService(@RequestParam String venueIds){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        return ResultInfoUtil.success(roomService.selectRoomByServiceId(venueIds,companyId));
    }

    /**
     * 查询场馆下面的拍摄间或者房间
     * @param venueId
     * @param roomType
     * @return
     */
    //查询场馆下面的化妆间 1 或者 拍摄间 2
    @GetMapping("/find_room_by_venue_id")
    public ResultInfo findRoomByVenueId(Integer venueId, Integer roomType){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<Room> rooms = roomService.findRoomByVenueId(companyId, venueId, roomType);
        return ResultInfoUtil.success(rooms);
    }

    /**
     * 化妆间或者房间排序
     * @param rooms
     * @return
     */
    //化妆间排序 1  或  拍摄间排序 2
    @PostMapping("/room_sort")
    public ResultInfo roomSort(@RequestBody List<Room> rooms){
        roomService.roomSort(rooms);
        return ResultInfoUtil.success();
    }

    /**
     * 化妆间等级等级排序
     */
    @PostMapping("/room_level_sort")
    public ResultInfo roomLevelSort(@RequestBody List<LevelAndRoomDTO> levelAndRoomDTOS){
        roomService.roomLevelSort(levelAndRoomDTOS);
        return ResultInfoUtil.success();
    }

    /**
     * 查询房间等级 和 下面的房间
     * 排序前 先查询所有的数据
     * @param venueId
     * @param roomType
     * @return
     */
    @GetMapping("get_all_room_and_type")
    public ResultInfo getLevelAndRoom(Integer venueId,String roomType){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
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

    //添加分类 和 房间(房间可添加 也可以不添加)  添加到字典表
    @PostMapping("/add_room_type")
    public ResultInfo addRoomLevel(@RequestBody LevelAndRoomDTO levelAndRoomDTO){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        levelAndRoomDTO.setCompanyId(companyId);
        roomService.addRoomLevel(levelAndRoomDTO);
        return ResultInfoUtil.success();
    }

    /**
     * 批量添加房间
     */
    @PostMapping("/bat_add_room")
    public ResultInfo batAddRoom(@RequestBody List<Room> rooms){
        roomService.batAddRoom(rooms);
        return ResultInfoUtil.success();
    }


    /**
     * 批量添加和编辑房间
     * @param rooms
     * @return
     */
    @PostMapping("/bat_insert_or_update")
    public ResultInfo batInsertOrUpdate(@RequestBody List<Room> rooms){
        roomService.batInsertOrUpdate(rooms);
        return ResultInfoUtil.success();
    }

    /**
     * 批量编辑房间
     */
    @PostMapping("/bat_update_room")
    public ResultInfo batUpdateRoom(@RequestBody List<Room> rooms){
        roomService.batUpdateRoom(rooms);
        return ResultInfoUtil.success();
    }

    /**
     * 修改房间等级
     * @param levelAndRoomDTO
     * @return
     */
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

    /**
     * 批量修改房间等级
     * @param levelAndRoomDTOs
     * @return
     */
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
