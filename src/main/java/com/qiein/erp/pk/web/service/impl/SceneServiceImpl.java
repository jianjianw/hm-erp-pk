package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.SceneDao;
import com.qiein.erp.pk.web.entity.po.Scene;
import com.qiein.erp.pk.web.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneDao sceneDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sceneDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Scene record) {
        return sceneDao.insert(record);
    }

    @Override
    public Scene selectByPrimaryKey(Integer id) {
        return sceneDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Scene> selectAll() {
        return sceneDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Scene record) {
        return sceneDao.updateByPrimaryKey(record);
    }
}
