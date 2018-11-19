package com.qiein.erp.pk.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.MealPO;
import com.qiein.erp.pk.web.entity.po.RolePO;
import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.entity.vo.MealSelectVO;
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
    int insertMeal(MealPO meal);
    /**
     * 查询所有套餐
     * @return
     */
    List<MealPO> selectAll(Integer companyId);
    /**
     * 编辑套餐
     * @return
     */
    int updateByMeal(MealPO meal);
    
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
	
	ServicePO selectServiceName(@Param("serviceId")Integer serviceId, @Param("companyId") Integer companyId);
	List<DictionaryErp> selectPhoto(@Param("companyId")Integer companyId);

	/**
	 * 套餐下拉框
	 * @param companyId
	 * @return
	 */
	List<MealSelectVO> mealSelect(@Param("companyId")Integer companyId,@Param("serviceId")Integer serviceId);
	/**
	 * 主套餐名去重
	 * @param companyId
	 * @return
	 */
	List<MealPO> mealReapt(MealPO meal);
	/**
	 * 套餐分类名去重
	 * @param companyId
	 * @return
	 */
	List<DictionaryErp> mealTypeRepeat(DictionaryErp dictionaryErp);
	/**
	 * 查询其他服务
	 * @param companyId
	 * @return
	 */
	List<RolePO> selectOtherService(Integer companyId);
}