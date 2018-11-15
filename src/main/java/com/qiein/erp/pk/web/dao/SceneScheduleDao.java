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

    int insert(SceneSchedulePO sceneSchedulePO);

    SceneSchedulePO selectByPrimaryKey(Integer id);

    List<SceneSchedulePO> selectAll();

    int updateByPrimaryKey(SceneSchedulePO sceneSchedulePO);


    /**
     * 根据拍摄间档期id打卡
     * @param companyId
     * @param id
     * @param statusId
     */
    void punchIn(@Param("companyId") Integer companyId,
                 @Param("id") Integer id,
                 @Param("statusId") Integer statusId);

    /**
     * 批量新增或编辑
     * @param sceneSchedulePOS
     */
    void batSaveOrUpdate(List<SceneSchedulePO> sceneSchedulePOS);

    /**
     * 保存返回id
     * @param sceneSchedulePO
     * @return
     */
    SceneSchedulePO saveReturnId(SceneSchedulePO sceneSchedulePO);

    /**
     * 批量保存
     * @param sceneSchedulePOS
     * @return
     */
    List<SceneSchedulePO> batSave(List<SceneSchedulePO> sceneSchedulePOS);
}
