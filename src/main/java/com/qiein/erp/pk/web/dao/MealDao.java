package com.qiein.erp.pk.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.Meal;
import com.qiein.erp.pk.web.entity.po.ServicePO;
/**
 * 套餐
 * @author Han
 *
 */
public interface MealDao {
    
	/**
	 * 
	 * @param meal
	 * @return
	 */
    int insertMeal(Meal meal);
    /**
     * 查询所有套餐
     * @return
     */
    List<Meal> selectAll();
    /**
     * 编辑套餐
     * @return
     */
    int updateByMeal(Meal meal);
    
    /**
     * 查询套餐类别
     * @return
     */
	List<DictionaryErp> selectMealType(int companyId);
	/**
     * 新增套餐类别
     * @return
     */
	void insertMealType( DictionaryErp dictionaryErp);
	
	 /**
     * 查询服务ID
     * @return
     */
	List<ServicePO> selectServiceId(int companyId);
	 /**
     * 编辑套餐分类
     * @return
     */
	void updateMealType(DictionaryErp dictionaryErp);
	DictionaryErp selecDicName(@Param("mealType") Integer mealType,@Param("companyId")Integer companyId);
	
}