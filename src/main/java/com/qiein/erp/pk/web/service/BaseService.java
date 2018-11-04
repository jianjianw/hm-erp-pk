package com.qiein.erp.pk.web.service;

import com.qiein.erp.pk.web.entity.po.Base;

import java.util.List;

public interface BaseService {

    int deleteByPrimaryKey(Integer id);

    int insert(Base base);

    Base selectByPrimaryKey(Integer id);

    List<Base> selectAll();

    int updateByPrimaryKey(Base base);
}
