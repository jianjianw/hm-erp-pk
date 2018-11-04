package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Scene;

import java.util.List;

public interface SceneService {

    int deleteByPrimaryKey(Integer id);

    int insert(Scene record);

    Scene selectByPrimaryKey(Integer id);

    List<Scene> selectAll();

    int updateByPrimaryKey(Scene record);
}
