package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.BasePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 场地
 * author:wang lei
 * date : 2018-11-04
 * */
public interface BaseDao {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    int insert(BasePO base);

    BasePO selectByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    List<BasePO> selectAll(@Param("companyId")Integer companyId);

    int updateByPrimaryKey(BasePO base);

    /**
     * 查询所有开启的基地
     * @param companyId
     * @return
     */
    List<BasePO> selectOpenAll(Integer companyId);

    /**
     * 批量新增
     * @param bases
     */
    void batInsert(List<BasePO> bases);

    /**
     * 批量编辑
     * @param bases
     */
    void batUpdate(List<BasePO> bases);

    /**
     * 基地排序
     * @param bases
     */
    void baseSort(List<BasePO> bases);

    /**
     * 名字查重
     * @param companyId
     * @param id
     * @param name
     * @return
     */
    String checkName(@Param("companyId") Integer companyId,
                     @Param("id") Integer id,
                     @Param("name") String name);
}