package com.qiein.erp.pk.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiein.erp.pk.web.dao.MealDao;
import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.Meal;
import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.service.MealService;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealDao mealDao;

	@Override
	public int insertMeal(Meal meal) {
		return mealDao.insertMeal(meal);
	}

	@Override
	public List<Meal> selectAll() {
		List<Meal> selectAll = mealDao.selectAll();
		return selectAll;
	}

	@Override
	public int updateByMeal(Meal meal) {
		return mealDao.updateByMeal(meal);
	}

	@Override
	public List<DictionaryErp> selectMealType(int companyId) {
		List<DictionaryErp> mealTypes=mealDao.selectMealType(companyId);
		return mealTypes;
	}

	@Override
	public List<ServicePO> selectServiceId(int companyId) {
		List<ServicePO> servicePo=mealDao.selectServiceId(companyId);
		return servicePo;
	}

	@Override
	public void insertMealType(DictionaryErp dictionaryErp) {
		mealDao.insertMealType(dictionaryErp);
	}

	@Override
	public void updateMealType(DictionaryErp dictionaryErp) {
		mealDao.updateMealType(dictionaryErp);
	}

	
}
