package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.BaseDao;
import com.qiein.erp.pk.web.entity.po.Base;
import com.qiein.erp.pk.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseDao baseDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Base base) {
        return baseDao.insert(base);
    }

    @Override
    public Base selectByPrimaryKey(Integer id) {
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Base> selectAll() {
        return baseDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Base base) {
        return baseDao.updateByPrimaryKey(base);
    }
}
