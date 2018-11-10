package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.entity.po.ServiceVenuePO;
import com.qiein.erp.pk.web.entity.vo.RoomGroupByServiceIdVO;
import com.qiein.erp.pk.web.entity.vo.ServiceVO;
import com.qiein.erp.pk.web.entity.vo.VenueServiceVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 服务dao
 * author:xiangliang 2018/11/05
 */
@Repository
public interface ServiceDao {
    /**
     * 添加服务
     * @param servicePO
     */
     int addService(ServicePO servicePO);

     void addServiceVenue(@Param("serviceVenuePOS")List<ServiceVenuePO> serviceVenuePOS);

     void addServiceVenueLink(@Param("makeupRoomIds") String makeupRoomIds, @Param("shootRoomIds")String shootRoomIds,@Param("companyId") int companyId,@Param("serviceId") int serviceId);

     void deleteServiceVenue(@Param("companyId") int companyId,@Param("serviceId") int serviceId);

    void deleteServiceVenueLink(@Param("companyId") int companyId,@Param("serviceId") int serviceId);
    /**
     * 添加服务
     * @param servicePO
     */
    int updateService(ServicePO servicePO);

    /**
     * 查询页面
     */
    List<ServiceVO> select(@Param("companyId")int companyId);

    List<RoomGroupByServiceIdVO> selectRoomGroupByServiceId(@Param("companyId")int companyId);
    /**
     * 查重
     */
    String checkWasIn(@Param("serviceName")String serviceName,@Param("companyId")Integer companyId);
    /**
     * 场馆服务关联查询（场馆档期用）
     */
    List<VenueServiceVO> venueService(Integer companyId);


}
