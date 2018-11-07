package com.qiein.erp.pk.web.service;

import java.util.List;

import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.Meal;
import com.qiein.erp.pk.web.entity.po.ServicePO;

public interface MealService {

	int insertMeal(Meal meal);

	List<Meal> selectAll();

	int updateByMeal(Meal meal);

	List<DictionaryErp> selectMealType(int companyId);

	List<ServicePO> selectServiceId(int companyId);

	void insertMealType(DictionaryErp dictionaryErp);

	void updateMealType(DictionaryErp dictionaryErp);



    
}
