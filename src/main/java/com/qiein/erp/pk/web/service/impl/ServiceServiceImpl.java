package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.web.dao.ServiceDao;
import com.qiein.erp.pk.web.entity.dto.ServiceDTO;
import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.entity.po.ServiceVenuePO;
import com.qiein.erp.pk.web.entity.vo.*;
import com.qiein.erp.pk.web.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务serice
 * author:xiangliang 2018/11/05
 */
@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceDao serviceDao;

    /**
     * 增加服务
     *
     * @param serviceDTO
     */
    public void addService(ServiceDTO serviceDTO) {
        ServicePO servicePO = new ServicePO();
        servicePO.setCompanyId(serviceDTO.getCompanyId());
        servicePO.setServiceName(serviceDTO.getServiceName());
        servicePO.setServiceType(serviceDTO.getServiceType());
        servicePO.setShootNum(serviceDTO.getShootNum());
        servicePO.setMakeupNum(serviceDTO.getMakeupNum());
        servicePO.setVideoNum(serviceDTO.getVideoNum());
        servicePO.setServiceStatus(serviceDTO.isStatus());

        serviceDao.addService(servicePO);
        int i=servicePO.getId();
        List<ServiceVenuePO> serviceVenuePOS = new ArrayList<>();
        for (String venceId : serviceDTO.getVenueIds().split(CommonConstant.STR_SEPARATOR)) {
            ServiceVenuePO serviceVenuePO = new ServiceVenuePO();
            serviceVenuePO.setCompanyId(serviceDTO.getCompanyId());
            serviceVenuePO.setServiceId(i);
            serviceVenuePO.setVenueId(Integer.parseInt(venceId));
            serviceVenuePOS.add(serviceVenuePO);
        }

        serviceDao.addServiceVenue(serviceVenuePOS);
        String makeupIds=CommonConstant.NULL_STR;
        String shootIds=CommonConstant.NULL_STR;
        for(String shootId:serviceDTO.getShootLinkIds().split(CommonConstant.STR_SEPARATOR)){
            shootIds+=shootId.split(CommonConstant.ROD_SEPARATOR)[1]+CommonConstant.STR_SEPARATOR;
        }
        for(String makeupLinkId:serviceDTO.getMakeupLinkIds().split(CommonConstant.STR_SEPARATOR)){
            makeupIds+=makeupLinkId.split(CommonConstant.ROD_SEPARATOR)[1]+CommonConstant.STR_SEPARATOR;
        }
        shootIds=shootIds.substring(0,shootIds.length()-1);
        makeupIds=makeupIds.substring(0,makeupIds.length()-1);
        serviceDao.addServiceVenueLink(makeupIds,shootIds, serviceDTO.getCompanyId(), i);
    }

    /**
     * 修改服务
     *
     * @param serviceDTO
     */
    public void editService(ServiceDTO serviceDTO) {
        serviceDao.deleteServiceVenueLink(serviceDTO.getCompanyId(), serviceDTO.getId());
        serviceDao.deleteServiceVenue(serviceDTO.getCompanyId(), serviceDTO.getId());
        ServicePO servicePO = new ServicePO();
        servicePO.setCompanyId(serviceDTO.getCompanyId());
        servicePO.setServiceName(serviceDTO.getServiceName());
        servicePO.setServiceType(serviceDTO.getServiceType());
        servicePO.setShootNum(serviceDTO.getShootNum());
        servicePO.setMakeupNum(serviceDTO.getMakeupNum());
        servicePO.setVideoNum(serviceDTO.getVideoNum());
        servicePO.setServiceStatus(serviceDTO.isStatus());
        servicePO.setId(serviceDTO.getId());
        serviceDao.updateService(servicePO);
        List<ServiceVenuePO> serviceVenuePOS = new ArrayList<>();
        for (String venceId : serviceDTO.getVenueIds().split(CommonConstant.STR_SEPARATOR)) {
            ServiceVenuePO serviceVenuePO = new ServiceVenuePO();
            serviceVenuePO.setCompanyId(serviceDTO.getCompanyId());
            serviceVenuePO.setServiceId(serviceDTO.getId());
            serviceVenuePO.setVenueId(Integer.parseInt(venceId));
            serviceVenuePOS.add(serviceVenuePO);
        }

        serviceDao.addServiceVenue(serviceVenuePOS);
        String makeupIds=CommonConstant.NULL_STR;
        String shootIds=CommonConstant.NULL_STR;
        for(String shootId:serviceDTO.getShootLinkIds().split(CommonConstant.STR_SEPARATOR)){
            shootIds+=shootId.split(CommonConstant.ROD_SEPARATOR)[1]+CommonConstant.STR_SEPARATOR;
        }
        for(String makeupLinkId:serviceDTO.getMakeupLinkIds().split(CommonConstant.STR_SEPARATOR)){
            makeupIds+=makeupLinkId.split(CommonConstant.ROD_SEPARATOR)[1]+CommonConstant.STR_SEPARATOR;
        }
        shootIds=shootIds.substring(0,shootIds.length()-1);
        makeupIds=makeupIds.substring(0,makeupIds.length()-1);
        serviceDao.addServiceVenueLink(makeupIds, shootIds, serviceDTO.getCompanyId(), serviceDTO.getId());


    }

    /**
     * 获取数据
     */
    public List<ServiceVO> select(int companyId) {
        List<ServiceVO> list = serviceDao.select(companyId);
        List<RoomGroupByServiceIdVO> check=serviceDao.selectRoomGroupByServiceId(companyId);
        for(ServiceVO serviceVO:list){
            List<RoomGroupByServiceIdVO> makeupRooms=new ArrayList<>();
            List<RoomGroupByServiceIdVO> shootRooms=new ArrayList<>();
            for(RoomGroupByServiceIdVO roomGroupByServiceIdVO:check){
                if(serviceVO.getId().equals(roomGroupByServiceIdVO.getServiceId())&&roomGroupByServiceIdVO.getRoomType()==1){
                    makeupRooms.add(roomGroupByServiceIdVO);
                }
                if(serviceVO.getId().equals(roomGroupByServiceIdVO.getServiceId())&&roomGroupByServiceIdVO.getRoomType()==2){
                    shootRooms.add(roomGroupByServiceIdVO);
                }

            }
            serviceVO.setShootRoom(shootRooms);
            serviceVO.setMakeupRoom(makeupRooms);
        }
        for(ServiceVO serviceVO:list){
            String[] counts=serviceVO.getMakeupRoomNum().split(CommonConstant.FILE_SEPARATOR);
            if(counts[0].equals(counts[1])){
                serviceVO.setMakeupRoomNum("全部");
            }
            counts=serviceVO.getShootRoomNum().split(CommonConstant.FILE_SEPARATOR);
            if(counts[0].equals(counts[1])){
                serviceVO.setShootRoomNum("全部");
            }
            StringBuilder sb=new StringBuilder();
            if(serviceVO.getShootNum()!=0){
                sb.append("摄").append(serviceVO.getShootNum());
            }
            if(serviceVO.getMakeupNum()!=0){
                sb.append("化").append(serviceVO.getMakeupNum());
            }
            serviceVO.setPeopleNum(sb.toString());
        }
        return list;
    }
    /**
     * 查重
     */
    public String checkWasIn(String serviceName,Integer companyId){
        return serviceDao.checkWasIn(serviceName,companyId);
    }
    /**
     * 场馆服务关联查询（场馆档期用）
     */
    public List<VenueServiceVO> venueService(Integer companyId){
        List<VenueServiceVO> list=serviceDao.venueService(companyId);
        return list;
    }

    @Override
    public List<ServiceVenueRoomVO> findServiceAndMakeupRooms(Integer companyId, Integer venueId) {

        //查询场馆下面的服务
        List<ServiceVenueRoomVO> serviceByVenues = serviceDao.findServiceByVenueId(companyId, venueId);
        Integer roomType = 1;

        //场馆服务下面的化妆间
        List<VenueAndRoomVO> rooms =serviceDao.selectRoomsByVenueId(companyId,venueId,roomType);

        for(ServiceVenueRoomVO serviceVenueRoomVO: serviceByVenues){
            Integer voVenueId = serviceVenueRoomVO.getVenueId();
            Integer serviceId = serviceVenueRoomVO.getServiceId();
            for (VenueAndRoomVO room : rooms ){
                Integer venueId1 = room.getVenueId();
                Integer serviceId1 = room.getServiceId();
                if(voVenueId.equals(venueId1) && serviceId.equals(serviceId1)){
                    serviceVenueRoomVO.getMakeupRooms().add(room);
                }
            }

        }
        return serviceByVenues;
    }
}
