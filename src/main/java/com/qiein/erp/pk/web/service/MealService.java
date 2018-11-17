package com.qiein.erp.pk.web.service;

import java.util.List;

import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.MealPO;
import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.entity.vo.MealSelectVO;

public interface MealService {
	/**
     * 新增套餐
     * @return
     */
	int insertMeal(MealPO meal);
	/**
     * 查询所有套餐
     * @return
     */
	List<MealPO> selectAll(Integer companyId);
	/**
     * 编辑主套餐
     * @return
     */
	int updateByMeal(MealPO meal);
	/**
     * 查询套餐类别
     * @return
     */
	List<DictionaryErp> selectMealType(int companyId);
	/**
     * 查询服务ID
     * @return
     */
	List<ServicePO> selectServiceId(int companyId);
	/**
     * 新增套餐类别
     * @return
     */
	void insertMealType(DictionaryErp dictionaryErp);
	/**
     * 编辑套餐类别
     * @return
     */
	void updateMealType(DictionaryErp dictionaryErp);

	DictionaryErp selecDicName(Integer mealType,Integer companyId);

	ServicePO selectServiceName(Integer serviceId, Integer companyId);

	List<DictionaryErp> selectPhoto(int companyId);
	/**
	 * 套餐下拉框
	 * @param companyId
	 * @return
	 */
	List<MealSelectVO> mealSelect(Integer companyId ,Integer serviceId);
	
    
}
