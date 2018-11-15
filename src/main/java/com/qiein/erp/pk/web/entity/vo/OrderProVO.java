package com.qiein.erp.pk.web.entity.vo;

import java.util.List;

/**
 * 订单编辑页面vo
 * author xiangliang
 */
public class OrderProVO {
    private Integer orderId;//订单id
    private String orderNum;//订单编号
    private String mealId;//套餐id
    private Integer staffId;//销售id
    private String staffName;//销售姓名
    private Integer srcType;//渠道id
    private String kzName;//老公或者爸爸的姓名
    private String kzPhone;//老公或者爸爸的电话
    private String mateName;//老婆或者妈妈的姓名
    private String matePhone;//老婆或者妈妈的电话
    private String childName;//孩子姓名或者写真的客户姓名
    private String age;//年龄
    private String sex;//性别
    private String birthDay;//生日
    private String marryTime;//婚期
    private String address;//地址
    private Integer companyId;
    private String orderTime;//订单时间
    private List<ProcessVO> processVOS;//订单下的流程们

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public String getKzName() {
        return kzName;
    }

    public void setKzName(String kzName) {
        this.kzName = kzName;
    }

    public String getKzPhone() {
        return kzPhone;
    }

    public void setKzPhone(String kzPhone) {
        this.kzPhone = kzPhone;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMatePhone() {
        return matePhone;
    }

    public void setMatePhone(String matePhone) {
        this.matePhone = matePhone;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getMarryTime() {
        return marryTime;
    }

    public void setMarryTime(String marryTime) {
        this.marryTime = marryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ProcessVO> getProcessVOS() {
        return processVOS;
    }

    public void setProcessVOS(List<ProcessVO> processVOS) {
        this.processVOS = processVOS;
    }
}
