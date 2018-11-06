package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Scene;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SceneDao {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    int insert(Scene scene);

    Scene selectByPrimaryKey(@Param("id") Integer id, @Param("companyId")Integer companyId);

    List<Scene> selectAll( @Param("companyId")Integer companyId);

    int updateByPrimaryKey(Scene scene);
}