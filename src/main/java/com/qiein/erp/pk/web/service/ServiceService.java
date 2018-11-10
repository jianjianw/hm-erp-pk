package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.dto.ServiceDTO;
import com.qiein.erp.pk.web.entity.vo.ServiceVO;
import com.qiein.erp.pk.web.entity.vo.VenueServiceVO;

import java.util.List;

/**
 * 服务serice
 * author:xiangliang 2018/11/05
 */
public interface ServiceService {
    /**
     * 增加服务
     * @param serviceDTO
     */
    void addService(ServiceDTO serviceDTO);

    /**
     * 修改服务
     * @param serviceDTO
     */
    void editService(ServiceDTO serviceDTO);

    /**
     *
     * @param companyId
     * @return
     */
    List<ServiceVO> select(int companyId);
    /**
     * 查重
     */
    String checkWasIn(String serviceName,Integer companyId);
    /**
     * 场馆服务关联查询（场馆档期用）
     */
    List<VenueServiceVO> venueService(Integer companyId);
}
