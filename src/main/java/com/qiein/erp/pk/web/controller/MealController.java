package com.qiein.erp.pk.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.MealPO;
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
    		/*//查询套餐类别名称
        	DictionaryErp dictionaryErp=mealService.selecDicName(meal.getMealType(),meal.getCompanyId());
        	meal.setMealTypeName(dictionaryErp.getDicName());
        	//查询拍摄名称
        	DictionaryErp photo=mealService.selecDicName(meal.getPhotoType(),meal.getCompanyId());
        	meal.setPhotoName(photo.getDicName());
        	//查询服务类别名称
        	ServicePO servicePO=mealService.selectServiceName(meal.getServiceId(),meal.getCompanyId());
            meal.setServiceName(servicePO.getServiceName());
            System.out.println(JSONObject.toJSONString(meal));*/
            
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
    	/*//查询套餐类别名称
    	DictionaryErp dictionaryErp=mealService.selecDicName(meal.getMealType(),meal.getCompanyId());
    	meal.setMealTypeName(dictionaryErp.getDicName());
    	//查询拍摄名称
    	DictionaryErp photo=mealService.selecDicName(meal.getPhotoType(),meal.getCompanyId());
    	meal.setPhotoName(photo.getDicName());
    	//查询服务类别名称
    	ServicePO servicePO=mealService.selectServiceName(meal.getServiceId(),meal.getCompanyId());
        meal.setServiceName(servicePO.getServiceName());
        System.out.println(JSONObject.toJSONString(meal));*/
        
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
