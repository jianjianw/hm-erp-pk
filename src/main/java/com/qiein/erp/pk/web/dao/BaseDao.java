package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Base;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 场地
 * author:wang lei
 * date : 2018-11-04
 * */
public interface BaseDao {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    int insert(Base base);

    Base selectByPrimaryKey(@Param("id") Integer id,@Param("companyId")Integer companyId);

    List<Base> selectAll(@Param("companyId")Integer companyId);

    int updateByPrimaryKey(Base base);

    /**
     * 查询所有开启的基地
     * @param companyId
     * @return
     */
    List<Base> selectOpenAll(Integer companyId);
}