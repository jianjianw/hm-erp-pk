package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.dto.SceneDTO;
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
    Integer saveReturnId(SceneSchedulePO sceneSchedulePO);

    /**
     * 批量保存
     * @param sceneSchedulePOS
     * @return
     */
    Integer batSave(List<SceneSchedulePO> sceneSchedulePOS);

    /**
     * 根据场景和时间 查询场景档期   (当天的时间  时间具体到天  2018-11-10 : 00:00:00  - 2018-11-10 : 23:59:59)
     * @param sceneDTO
     * @return
     */
    List<SceneSchedulePO> selectSceneScheduleBySceneIdAndDate(SceneDTO sceneDTO);

    /**
     * 根据ids查询场景档期  多个
     * @param companyId
     * @param ids
     * @return
     */
    List<SceneSchedulePO> findSceneScheduleByIds(@Param("companyId") Integer companyId,
                                                 @Param("ids") List<Integer> ids);
    /**
     * 根据场景和时间 查询场景档期   (具体到时间点  9:00 - 9:30)
     * @param sceneDTO
     * @return
     */
    List<SceneSchedulePO> selectSceneScheduleBySceneIdAndDateTime(SceneDTO sceneDTO);

    /**
     * 批量删除数据
     * @param deleteIds
     */
    void batDelete(List<Integer> deleteIds);

    /**
     * 批量编辑
     * @param sceneSchedulePOS
     */
    void batUpdate(List<SceneSchedulePO> sceneSchedulePOS);

}
