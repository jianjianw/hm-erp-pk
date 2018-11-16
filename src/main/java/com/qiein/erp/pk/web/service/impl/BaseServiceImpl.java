package com.qiein.erp.pk.web.service.impl;

import com.qiein.erp.pk.web.dao.BaseDao;
import com.qiein.erp.pk.web.entity.po.BasePO;
import com.qiein.erp.pk.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 场地
 * author:wang lei
 * date : 2018-11-04
 * */
@Service
@Transactional
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseDao baseDao;
    @Override
    public int deleteByPrimaryKey(Integer id,Integer companyId) {
        return baseDao.deleteByPrimaryKey(id,companyId);
    }

    @Override
    public int insert(BasePO base) {
        return baseDao.insert(base);
    }

    @Override
    public BasePO selectByPrimaryKey(Integer id, Integer companyId) {
        return baseDao.selectByPrimaryKey(id,companyId);
    }

    @Override
    public List<BasePO> selectAll(Integer companyId) {
        return baseDao.selectAll(companyId);
    }

    @Override
    public int updateByPrimaryKey(BasePO base) {
        return baseDao.updateByPrimaryKey(base);
    }

    @Override
    public void batInsertOrUpdate(List<BasePO> bases) {

        for(BasePO base : bases){
            BasePO base1 = baseDao.selectByPrimaryKey(base.getId(), base.getCompanyId());
            if(base1 == null){
                baseDao.insert(base);
            }else{
                baseDao.updateByPrimaryKey(base);
            }

        }
        //baseDao.batUpdate(bases);
        //这个方法不行
        //baseDao.batInsertOrUpdate(bases);

    }

    @Override
    public List<BasePO> selectOpenAll(Integer companyId) {
        return baseDao.selectOpenAll(companyId);
    }

    @Override
    public void batInsert(List<BasePO> bases) {
        baseDao.batInsert(bases);
    }

    @Override
    public void batUpdate(List<BasePO> bases) {
        baseDao.batUpdate(bases);
    }

    @Override
    public void baseSort(List<BasePO> bases) {
        baseDao.baseSort(bases);
    }
}
