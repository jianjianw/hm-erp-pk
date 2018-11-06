package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.SceneDao;
import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 场景
 * author:wang lei
 * date : 2018-11-04
 * */
@Service
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneDao sceneDao;

    @Override
    public int deleteByPrimaryKey(Integer id,Integer companyId) {
        return sceneDao.deleteByPrimaryKey(id,companyId);
    }

    @Override
    public int insert(Scene scene) {
        return sceneDao.insert(scene);
    }

    @Override
    public Scene selectByPrimaryKey(Integer id,Integer companyId) {
        return sceneDao.selectByPrimaryKey(id,companyId);
    }

    @Override
    public List<Scene> selectAll(Integer companyId) {
        return sceneDao.selectAll(companyId);
    }

    @Override
    public int updateByPrimaryKey(Scene scene) {
        return sceneDao.updateByPrimaryKey(scene);
    }
}
