package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 拍摄间档期
 * wang lei 
 */
public interface SceneScheduleDao {


    List<SceneSchedulePO> selectSceneScheduleByDate(@Param("companyId") Integer companyId,
                                                   @Param("venueId")Integer venueId,
                                                   @Param("startTime")Integer startTime,
                                                   @Param("endTime")Integer endTime);

    int deleteByPrimaryKey(Integer id);

    int insert(SceneSchedulePO record);

    SceneSchedulePO selectByPrimaryKey(Integer id);

    List<SceneSchedulePO> selectAll();

    int updateByPrimaryKey(SceneSchedulePO record);


}
