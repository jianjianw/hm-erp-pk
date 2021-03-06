package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.web.entity.dto.SceneDTO;
import com.qiein.erp.pk.web.entity.dto.ShootScheduleDTO;
import com.qiein.erp.pk.web.entity.po.SceneSchedulePO;
import com.qiein.erp.pk.web.entity.vo.SceneScheduleVO;

import java.util.List;
/**
 * 拍摄间档期
 * wang lei
 * 2018-11-9
 */
public interface SceneScheduleService {

    /**
     * 根据开始时间和结束时间查询档期
     * @param companyId
     * @param venueId
     * @param dateTime
     * @return
     */
    ShootScheduleDTO selectSceneScheduleByDate(Integer companyId, Integer venueId, Integer dateTime);

    /**
     * 拍摄间档期打卡
     * @param companyId
     * @param id
     */
    void punchIn(Integer companyId, Integer id,Integer statusId);


    int insert(SceneSchedulePO sceneSchedulePO);

    int updateByPrimaryKey(SceneSchedulePO sceneSchedulePO);

    /**
     * 批批量新增或编辑
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
    List<SceneScheduleVO> batSave(List<SceneSchedulePO> sceneSchedulePOS);

    /**
     * 根据场景和时间(具体到天) 查询场景档期
     * @param sceneDTO
     * @return
     */
    List<SceneSchedulePO> selectSceneScheduleBySceneIdAndDate(SceneDTO sceneDTO);

    /**
     * 根据场景和时间(具体到时间2018-11-16 9:00 - 2018-11-16  9:30) 查询场景档期
     * @param sceneDTO
     * @return
     */
    List<SceneSchedulePO> selectSceneScheduleBySceneIdAndDateTime(SceneDTO sceneDTO);

    /**
     * 先查询再保存
     * @param sceneSchedulePOS
     * @return
     */
    ResultInfo batSaveSelect(List<SceneSchedulePO> sceneSchedulePOS);

    /**
     * 批量编辑
     * @param sceneSchedulePOS
     * @return
     */
    List<SceneSchedulePO> batUpdate(List<SceneSchedulePO> sceneSchedulePOS,List<Integer> deleteIds);

    /**
     * 根据ids查询场景档期  多个
     * @param companyId
     * @param ids
     * @return
     */
    List<SceneSchedulePO> findSceneScheduleByIds(Integer companyId,List<Integer> ids);


    /**
     * 先删除 后 插入
     * @param sceneSchedulePOS
     * @param deleteIds
     * @return
     */
    ResultInfo batDeleteUpdate(List<SceneSchedulePO> sceneSchedulePOS, List<Integer> deleteIds);
}
