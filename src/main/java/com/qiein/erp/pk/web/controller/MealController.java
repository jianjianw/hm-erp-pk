package com.qiein.erp.pk.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.MealPO;
import com.qiein.erp.pk.web.entity.po.RolePO;
import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.service.MealService;

/**
 * 套餐
 * */
@RestController
@RequestMapping("/meal")
public class MealController extends InitController{

    @Autowired
    private MealService mealService;  
    
    /**
     * 查询拍摄类别
     * @return
     */
    @GetMapping("/select_other_service")
    public ResultInfo selectOtherService(){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
         List<RolePO> RolePO= mealService.selectOtherService(companyId);
        return ResultInfoUtil.success(RolePO);
    }
    /**
     * 查询拍摄类别
     * @return
     */
    @GetMapping("/select_photo")
    public ResultInfo selectPhoto(){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
         List<DictionaryErp> photoTypes= mealService.selectPhoto(companyId);
        return ResultInfoUtil.success(photoTypes);
    }
    
    /**
     * 查询套餐类别
     * @return
     */
    @GetMapping("/select_meal_type")
    public ResultInfo selectMealType(){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
         List<DictionaryErp> mealTypes= mealService.selectMealType(companyId);
        return ResultInfoUtil.success(mealTypes);
    }
    /**
     * 新增套餐类别
     * @return
     */
    @PostMapping("/insert_meal_type")
    public ResultInfo insertMealType(@RequestBody DictionaryErp dictionaryErp ){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
    	if(dictionaryErp.getDicName() == null){
    		return ResultInfoUtil.error(9999,"请输入分类名称");
    	}
    	if(!dictionaryErp.getDicType().equals("meal_type")){
    		return ResultInfoUtil.error(9999,"类型id错误");
    	}
    		dictionaryErp.setCompanyId(companyId);
    		//套餐分类名去重
    		List<DictionaryErp> dic=mealService.mealTypeRepeat(dictionaryErp);
    		if(dic!=null && dic.size()>0){
    			return ResultInfoUtil.success("该套餐分类名已存在");
    		}
    		mealService.insertMealType(dictionaryErp);
        return ResultInfoUtil.success();
    }
    /**
     * 编辑套餐类别
     * @return
     */
    @PostMapping("/update_meal_type")
    public ResultInfo updateMealType(@RequestBody List<DictionaryErp> dictionaryErps){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
    	for (DictionaryErp dictionaryErp : dictionaryErps) {
    		dictionaryErp.setCompanyId(companyId);
       	 mealService.updateMealType(dictionaryErp);
		}
        return ResultInfoUtil.success();
    }
    
    /**
     * 查询服务ID
     * @return
     */
    @GetMapping("/select_service_id")
    public ResultInfo selectServiceId(){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
         List<ServicePO> servicePo= mealService.selectServiceId(companyId);
        
        return ResultInfoUtil.success(servicePo);
    }
    /**
     * 新增主套餐
     * @return
     */
    @PostMapping("/insert_meal")
    public ResultInfo insertMeal(@RequestBody MealPO meal){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
    		if(meal==null){
    			return ResultInfoUtil.error(9999, "缺少参数");
    		}
    		meal.setCompanyId(companyId);
    		//新增主套餐去重
    		List<MealPO> mealRepeat=mealService.mealReapt(meal);
    		if(mealRepeat!=null && mealRepeat.size()>0){
    			 return ResultInfoUtil.success("此套餐名已存在");
    		}
    		mealService.insertMeal(meal);
        return ResultInfoUtil.success();
    }
    
    /**
     * 查询所有套餐
     * @return
     */
    @GetMapping("/select_all")
    public ResultInfo selectAll(){
    	Integer companyId=getCurrentLoginStaff().getCompanyId();
        List<MealPO> meal = mealService.selectAll(companyId);
        List<DictionaryErp> mealTypes= mealService.selectMealType(companyId);
        if(meal!=null && mealTypes!=null){
        	for (MealPO mealPO : meal) {
            	for (DictionaryErp dictionaryErp : mealTypes) {
        			if(mealPO.getMealType().equals(dictionaryErp.getDicCode())){
        				mealPO.setMealTypeName(dictionaryErp.getDicName());
        			}
        		}
    		}
        }
        
        return ResultInfoUtil.success(meal);
    }
    /**
     * 编辑主套餐
     * @return
     */
    @PostMapping("/update_by_meal")
    public ResultInfo updateByPrimaryKey(@RequestBody MealPO meal){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
    	meal.setCompanyId(companyId);
        mealService.updateByMeal(meal);
        return ResultInfoUtil.success();
    }

    /**
     * 套餐下拉框
     * @return
     */
    @GetMapping("/meal_select")
    public ResultInfo mealSelect(@RequestParam(value = "serviceId",required = false) Integer serviceId){
        Integer companyId=getCurrentLoginStaff().getCompanyId();
        return ResultInfoUtil.success(mealService.mealSelect(companyId,serviceId));
    }
  
}
