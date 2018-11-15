package com.qiein.erp.pk.web.controller;


import com.qiein.erp.pk.exception.ExceptionEnum;
import com.qiein.erp.pk.util.ObjectUtil;
import com.qiein.erp.pk.util.RegexUtil;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.dto.VenueDTO;
import com.qiein.erp.pk.web.entity.po.Venue;
import com.qiein.erp.pk.web.service.BaseService;
import com.qiein.erp.pk.web.service.RoomService;
import com.qiein.erp.pk.web.service.SceneService;
import com.qiein.erp.pk.web.service.VenueService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 场馆 1 内景馆  2 门店
 * author:wang lei
 * date : 2018-11-04
 * */
@RestController
@RequestMapping("/venue")
public class VenueController extends InitController{

    private static Logger logger = LoggerFactory.getLogger(VenueController.class);

    @Autowired
    private VenueService venueService;


    @PostMapping("/delete_by_primary_key")
    public ResultInfo deleteByPrimaryKey(Integer id){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        int i = venueService.deleteByPrimaryKey(id,companyId);
        return ResultInfoUtil.success();
    }

    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody Venue venue){
        if(!RegexUtil.checkMobile(venue.getVenuePhone())){
            return ResultInfoUtil.error(ExceptionEnum.PHONE_ERROR);
        }

        //去掉对象中的空格
        ObjectUtil.objectStrParamTrim(venue);

        venueService.insert(venue);
        return ResultInfoUtil.success();
    }
    @GetMapping("/select_by_primary_key")
    public ResultInfo selectByPrimaryKey(Integer id){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        Venue venue = venueService.selectByPrimaryKey(id,companyId);
        return ResultInfoUtil.success(venue);
    }


    //显示所有门店 或者 内景馆
    @GetMapping("/select_all")
    public ResultInfo selectAll(Integer venueType){//venueType 1 内景馆   2 门店
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<VenueDTO> result = venueService.selectAll(companyId,venueType);
        return ResultInfoUtil.success(result);
    }


    @PostMapping("/update_by_primary_key")
    public ResultInfo updateByPrimaryKey(@RequestBody Venue venue){
        if(!RegexUtil.checkMobile(venue.getVenuePhone())){
            return ResultInfoUtil.error(ExceptionEnum.PHONE_ERROR);
        }
        //去掉对象中的空格
        ObjectUtil.objectStrParamTrim(venue);
        venueService.updateByPrimaryKey(venue);
        return ResultInfoUtil.success();
    }

    //内场馆排序 1  或  门店排序 2
    @PostMapping("/venue_sort")
    public ResultInfo venueSort(@RequestBody List<Venue> Venues){
        venueService.venueSort(Venues);
        return ResultInfoUtil.success();
    }

    /**
     * 内景馆的首页展示
     * @return
     */
    @GetMapping("/show_index")
    public ResultInfo showIndex(){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<VenueDTO> venueDTOS = venueService.showIndex(companyId);
        return ResultInfoUtil.success(venueDTOS);
    }


   @GetMapping("/get_venues")
    public ResultInfo getVenues(){

       Integer companyId=getCurrentLoginStaff().getCompanyId();
       return ResultInfoUtil.success(venueService.getVenues(companyId));
   }
}
