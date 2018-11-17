package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.BasePO;

import java.util.List;
/**
 * 场地
 * author:wang lei
 * date : 2018-11-04
 * */
public interface BaseService {

    int deleteByPrimaryKey(Integer id,Integer companyId);

    int insert(BasePO base);

    BasePO selectByPrimaryKey(Integer id, Integer companyId);

    List<BasePO> selectAll(Integer companyId);

    int updateByPrimaryKey(BasePO base);

    /**
     * 批量编辑场馆
     * @param bases
     */
    void batInsertOrUpdate(List<BasePO> bases);

    /*
    * 查询没有关闭的基地
    * */
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
    String checkName(Integer companyId, Integer id,String name);


}
