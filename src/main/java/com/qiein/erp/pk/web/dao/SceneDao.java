package com.qiein.erp.pk.web.dao;

import com.qiein.erp.pk.web.entity.po.Scene;

import java.util.List;

public interface SceneDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Scene scene);

    Scene selectByPrimaryKey(Integer id);

    List<Scene> selectAll();

    int updateByPrimaryKey(Scene scene);
}