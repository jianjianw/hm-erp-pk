package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.service.RoomService;
import com.qiein.erp.pk.web.service.SceneService;
import com.qiein.erp.pk.web.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 场馆 内景馆  门店
 * author:wang lei
 * date : 2018-11-04
 * */
@RestController
@RequestMapping("/venue")
public class VenueController {
    int companyId = 1;

    @Autowired
    private VenueService venueService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private SceneService sceneService;


    @PostMapping("/delete_by_primary_key")
    public ResultInfo deleteByPrimaryKey(Integer id){
        int i = venueService.deleteByPrimaryKey(id,companyId);
        return ResultInfoUtil.success();
    }

    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Venue venue){
        int insert = venueService.insert(venue);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_by_primary_key")
    public ResultInfo selectByPrimaryKey(Integer id){
        Venue venue = venueService.selectByPrimaryKey(id,companyId);
        return ResultInfoUtil.success(venue);
    }
    @GetMapping("/select_all")
    public ResultInfo selectAll(Integer venueType){//venueType 1 内景馆   2 门店
        int companyId=1;
        List<Venue> venues = venueService.selectAll(companyId,venueType);
        return ResultInfoUtil.success(venues);
    }
    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody Venue venue){
        int i = venueService.updateByPrimaryKey(venue);
        return ResultInfoUtil.success();
    }

    //内场馆排序 1  或  门店排序 2
    @PostMapping("/venue_sort")
    public ResultInfo venueSort(@RequestBody List<Venue> Venues){
        venueService.venueSort(Venues);
        return ResultInfoUtil.success();
    }

   /* @GetMapping("/show_index")
    public ResultInfo showIndex(){

        //要查询场馆下面的化妆间
        List<Room> rooms = roomService.selectAll(companyId);

        //查询场馆下面的拍摄间


        //查询拍摄间下面的场景，场景只关联了拍摄间

        List<Scene> scenes = sceneService.selectAll(companyId);

        return ResultInfoUtil.success();
    }*/
   @GetMapping("/get_venues")
    public ResultInfo getVenues(){
       return ResultInfoUtil.success(venueService.getVenues(companyId));
   }
}
