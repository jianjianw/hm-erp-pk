package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(Integer id){
        int i = venueService.deleteByPrimaryKey(id);
        return i;
    }

    @PostMapping("/insert")
    public int insert(Venue venue){
        int insert = venueService.insert(venue);
        return insert;
    }
    @GetMapping("/selectByPrimaryKey")
    public Venue selectByPrimaryKey(Integer id){
        Venue venue = venueService.selectByPrimaryKey(id);
        return venue;
    }
    @GetMapping("/selectAll")
    public List<Venue> selectAll(){
        List<Venue> venues = venueService.selectAll();
        return venues;
    }
    @PostMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(Venue venue){
        int i = venueService.updateByPrimaryKey(venue);
        return i;
    }
}
