package com.qiein.erp.pk.aop.validate;

import com.qiein.erp.pk.aop.validate.annotation.Phone;
import com.qiein.erp.pk.util.HttpUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ip地址校验实现类
 */
public class IPValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String ip, ConstraintValidatorContext constraintValidatorContext) {
        return HttpUtil.isIp(ip);
    }
}
