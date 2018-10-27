package com.qiein.erp.pk.aop.validate;

import com.qiein.erp.pk.aop.validate.annotation.Phone;
import com.qiein.erp.pk.util.RegexUtil;
import com.qiein.erp.pk.util.StringUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号码验证类
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        return RegexUtil.checkMobile(StringUtil.nullToStrTrim(phone));
    }
}
