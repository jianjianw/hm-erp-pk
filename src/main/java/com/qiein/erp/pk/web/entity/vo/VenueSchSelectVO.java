package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 场馆档期下拉框
 * author xiangliang
 */
public class VenueSchSelectVO {

    private Integer venueId;//场馆id
    private String venueName;//场馆名称
    private List<ServiceSchSelectVO> serviceSchSelectVOS;
}
