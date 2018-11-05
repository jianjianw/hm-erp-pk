package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.web.dao.ServiceDao;
import com.qiein.erp.pk.web.entity.dto.ServiceDTO;
import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.entity.po.ServiceVenuePO;
import com.qiein.erp.pk.web.entity.vo.ServiceVO;
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

        int i = serviceDao.addService(servicePO);
        List<ServiceVenuePO> serviceVenuePOS = new ArrayList<>();
        for (String venceId : serviceDTO.getVenueIds().split(CommonConstant.STR_SEPARATOR)) {
            ServiceVenuePO serviceVenuePO = new ServiceVenuePO();
            serviceVenuePO.setCompanyId(serviceDTO.getCompanyId());
            serviceVenuePO.setServiceId(i);
            serviceVenuePO.setVenueId(Integer.parseInt(venceId));
            serviceVenuePOS.add(serviceVenuePO);
        }

        serviceDao.addServiceVenue(serviceVenuePOS);
        serviceDao.addServiceVenueLink(serviceDTO.getMakeupLinkIds(), serviceDTO.getShookLinkIds(), serviceDTO.getCompanyId(), i);
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
        serviceDao.addServiceVenueLink(serviceDTO.getMakeupLinkIds(), serviceDTO.getShookLinkIds(), serviceDTO.getCompanyId(), serviceDTO.getId());


    }

    /**
     * 获取数据
     */
    public List<ServiceVO> select(int companyId) {
        List<ServiceVO> list = serviceDao.select(companyId);
        for(ServiceVO serviceVO:list){
            String[] counts=serviceVO.getMakeupRoomNum().split(CommonConstant.FILE_SEPARATOR);
            if(counts[1].equals(counts[2])){
                serviceVO.setMakeupRoomNum("全部");
            }
            counts=serviceVO.getShootRoomNum().split(CommonConstant.FILE_SEPARATOR);
            if(counts[1].equals(counts[2])){
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
}
