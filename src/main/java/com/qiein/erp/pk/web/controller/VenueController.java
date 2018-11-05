package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 场馆 内景馆
 * */
@RestController
@RequestMapping("/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping("/deleteByPrimaryKey")
    public ResultInfo deleteByPrimaryKey(Integer id){
        int i = venueService.deleteByPrimaryKey(id);
        return ResultInfoUtil.success();
    }

    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Venue venue){
        int insert = venueService.insert(venue);
        return ResultInfoUtil.success();
    }
    @GetMapping("/selectByPrimaryKey")
    public ResultInfo selectByPrimaryKey(Integer id){
        Venue venue = venueService.selectByPrimaryKey(id);
        return ResultInfoUtil.success(venue);
    }
    @GetMapping("/selectAll")
    public ResultInfo selectAll(){
        int companyId=1;
        List<Venue> venues = venueService.selectAll(companyId);
        return ResultInfoUtil.success(venues);
    }
    @PostMapping("/updateByPrimaryKey")
    public ResultInfo updateByPrimaryKey(@RequestBody Venue venue){
        int i = venueService.updateByPrimaryKey(venue);
        return ResultInfoUtil.success();
    }

    @GetMapping("/showIndex")
    public ResultInfo showIndex(){


        return ResultInfoUtil.success();
    }
}
