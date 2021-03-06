package com.qiein.erp.pk.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiein.erp.pk.web.dao.MealDao;
import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.MealPO;
import com.qiein.erp.pk.web.entity.po.RolePO;
import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.entity.vo.MealSelectVO;
import com.qiein.erp.pk.web.service.MealService;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealDao mealDao;
    /**
     * 新增套餐
     * @return
     */
	@Override
	public int insertMeal(MealPO meal) {
		return mealDao.insertMeal(meal);
	}
	/**
     * 查询所有套餐
     * @return
     */
	@Override
	public List<MealPO> selectAll(Integer companyId) {
		List<MealPO> selectAll = mealDao.selectAll(companyId);
		return selectAll;
	}
	/**
     * 编辑主套餐
     * @return
     */
	@Override
	public int updateByMeal(MealPO meal) {
		return mealDao.updateByMeal(meal);
	}
	/**
     * 查询套餐类别
     * @return
     */
	@Override
	public List<DictionaryErp> selectMealType(int companyId) {
		List<DictionaryErp> mealTypes=mealDao.selectMealType(companyId);
		return mealTypes;
	}
	/**
     * 查询服务ID
     * @return
     */
	@Override
	public List<ServicePO> selectServiceId(int companyId) {
		List<ServicePO> servicePo=mealDao.selectServiceId(companyId);
		return servicePo;
	}
	/**
     * 新增套餐类别
     * @return
     */
	@Override
	public void insertMealType(DictionaryErp dictionaryErp) {
		mealDao.insertMealType(dictionaryErp);
	}
	/**
     * 编辑套餐类别
     * @return
     */
	@Override
	public void updateMealType(DictionaryErp dictionaryErp) {
		mealDao.updateMealType(dictionaryErp);
	}
	/**
     * 编辑分类名称
     * @return
     */
	@Override
	public DictionaryErp selecDicName(Integer mealType,Integer companyId) {
		DictionaryErp dictionaryErp = mealDao.selecDicName(mealType,companyId);
		return dictionaryErp;
		
	}
	/**
     * 编辑服务名称
     * @return
     */
	@Override
	public ServicePO selectServiceName(Integer serviceId, Integer companyId) {
		ServicePO servicePO=mealDao.selectServiceName(serviceId,companyId);
		return servicePO;
	}
	/**
     * 编辑拍摄名称
     * @return
     */
	@Override
	public List<DictionaryErp> selectPhoto(int companyId) {
		List<DictionaryErp> photoTypes=mealDao.selectPhoto(companyId);
		return photoTypes;
	}
	/**
	 * 套餐下拉框
	 * @param companyId
	 * @return
	 */
	public List<MealSelectVO> mealSelect(Integer companyId ,Integer serviceId){
		return mealDao.mealSelect(companyId,serviceId);
	}
	/**
	 * 主套餐名去重
	 * @param companyId
	 * @return
	 */
	@Override
	public List<MealPO> mealReapt(MealPO meal) {
		List<MealPO> mealReapt=mealDao.mealReapt(meal);
		return mealReapt;
	}
	/**
	 * 套餐分类名去重
	 * @param companyId
	 * @return
	 */
	@Override
	public List<DictionaryErp> mealTypeRepeat(DictionaryErp dictionaryErp) {
		List<DictionaryErp> dic=mealDao.mealTypeRepeat(dictionaryErp);
		return dic;
	}
	/**
	 * 查询其他服务
	 * @param companyId
	 * @return
	 */
	@Override
	public List<RolePO> selectOtherService(Integer companyId) {
		List<RolePO> RolePO=mealDao.selectOtherService(companyId);
		return RolePO;
	}
	
}
