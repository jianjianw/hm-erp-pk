package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Base;

import java.util.List;

public interface BaseService {

    int deleteByPrimaryKey(Integer id,Integer companyId);

    int insert(Base base);

    Base selectByPrimaryKey(Integer id,Integer companyId);

    List<Base> selectAll(Integer companyId);

    int updateByPrimaryKey(Base base);
}
