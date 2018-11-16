package com.qiein.erp.pk.web.service;

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
     * 批量保存
     * @param sceneSchedulePOS
     * @return
     */
    List<SceneScheduleVO> batSave(List<SceneSchedulePO> sceneSchedulePOS);
}
