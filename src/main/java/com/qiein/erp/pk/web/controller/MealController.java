package com.qiein.erp.pk.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qiein.erp.pk.util.ResultInfo;
import com.qiein.erp.pk.util.ResultInfoUtil;
import com.qiein.erp.pk.web.entity.po.DictionaryErp;
import com.qiein.erp.pk.web.entity.po.Meal;
import com.qiein.erp.pk.web.entity.po.ServicePO;
import com.qiein.erp.pk.web.service.MealService;
/**
 * 套餐
 * */
@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealService mealService;
    
    /**
     * 查询套餐类别
     * @return
     */
    @GetMapping("/select_meal_type")
    public ResultInfo selectMealType(){
    	 int companyId=1;
         List<DictionaryErp> mealTypes= mealService.selectMealType(companyId);
        return ResultInfoUtil.success(mealTypes);
    }
    /**
     * 新增套餐类别
     * @return
     */
    @PostMapping("/insert_meal_type")
    public ResultInfo insertMealType(@RequestBody List<DictionaryErp> dictionaryErps ){
    	for (DictionaryErp dictionaryErp : dictionaryErps) {
    		dictionaryErp.setCompanyId(1);
    		mealService.insertMealType(dictionaryErp);
		}
    	//dictionaryErp.setCompanyId(1);
    	 //mealService.insertMealType(dictionaryErp);
        return ResultInfoUtil.success();
    }
    /**
     * 编辑套餐类别
     * @return
     */
    @PostMapping("/update_meal_type")
    public ResultInfo updateMealType(@RequestBody DictionaryErp dictionaryErp){
    	dictionaryErp.setCompanyId(1);
    	 mealService.updateMealType(dictionaryErp);
        return ResultInfoUtil.success();
    }
    
    /**
     * 查询服务ID
     * @return
     */
    @GetMapping("/select_service_id")
    public ResultInfo selectServiceId(){
    	 int companyId=1;
         List<ServicePO> servicePo= mealService.selectServiceId(companyId);
        return ResultInfoUtil.success(servicePo);
    }
    /**
     * 新增套餐
     * @return
     */
    @PostMapping("/insert_meal")
    public ResultInfo insertMeal(@RequestBody Meal meal){
    		mealService.insertMeal(meal);
        return ResultInfoUtil.success();
    }
    
    /**
     * 查询所有套餐
     * @return
     */
    @GetMapping("/select_all")
    public ResultInfo selectAll(){
        List<Meal> meal = mealService.selectAll();
        return ResultInfoUtil.success(meal);
    }
    /**
     * 编辑主套餐
     * @return
     */
    @PostMapping("/update_by_meal")
    public ResultInfo updateByPrimaryKey(@RequestBody Meal meal){
    	meal.setCompanyId(1);
    	DictionaryErp dictionaryErp=mealService.selecDicName(meal.getMealType(),meal.getCompanyId());
    	meal.setMealTypeName(dictionaryErp.getDicName());
        mealService.updateByMeal(meal);
        return ResultInfoUtil.success();
    }

  
}
