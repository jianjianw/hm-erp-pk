package com.qiein.erp.pk.web.entity.po;

/**
 * 保存订单参数
 * author:xiangliang
 */
public class OrderPO {
    private Integer orderId;//订单id
    private Integer proId;//流程id
    private String kzId;//客资id
    private String oldKzName;//老客姓名
    private String orderNum;//订单编号
    private String kzName;//客资姓名
    private String kzPhone;//客资电话
    private String mateName;//配偶姓名
    private String matePhone;//配偶电话
    private Integer mealId;//套餐id
    private Integer srcType;//渠道类型
    private Integer collectorId;//推广人id
    private Integer collectorName;//推广人姓名
    private String address;//地址
    private Integer companyId;
    private Integer venueSchId;//场馆档期id
    private Integer makeupRoomSchId;//化妆间档期id
    private Integer makeupSchId;//化妆师档期id
    private Integer shootSchId;//摄像师档期id
    private Integer planSchId;//企划档期id
    private String shootRoomSchIds;//拍摄间档期id
    private Integer orderType;//订单状态
    private String childName;//孩子姓名
    private Integer type;//拍摄类型
    private Integer age;//年龄
    private Integer sex;//性别
    private Integer birthDay;//生日
    private Integer marryTime;//婚期
    private Integer saleId;//销售id
    private Integer orderTime;
    private Integer letterId;

    public Integer getLetterId() {
        return letterId;
    }

    public void setLetterId(Integer letterId) {
        this.letterId = letterId;
    }

    public String getOldKzName() {
        return oldKzName;
    }

    public void setOldKzName(String oldKzName) {
        this.oldKzName = oldKzName;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getMarryTime() {
        return marryTime;
    }

    public void setMarryTime(Integer marryTime) {
        this.marryTime = marryTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
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

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    public Integer getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(Integer collectorName) {
        this.collectorName = collectorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getKzId() {
        return kzId;
    }

    public void setKzId(String kzId) {
        this.kzId = kzId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getVenueSchId() {
        return venueSchId;
    }

    public void setVenueSchId(Integer venueSchId) {
        this.venueSchId = venueSchId;
    }

    public Integer getMakeupRoomSchId() {
        return makeupRoomSchId;
    }

    public void setMakeupRoomSchId(Integer makeupRoomSchId) {
        this.makeupRoomSchId = makeupRoomSchId;
    }

    public Integer getMakeupSchId() {
        return makeupSchId;
    }

    public void setMakeupSchId(Integer makeupSchId) {
        this.makeupSchId = makeupSchId;
    }

    public Integer getShootSchId() {
        return shootSchId;
    }

    public void setShootSchId(Integer shootSchId) {
        this.shootSchId = shootSchId;
    }

    public Integer getPlanSchId() {
        return planSchId;
    }

    public void setPlanSchId(Integer planSchId) {
        this.planSchId = planSchId;
    }

    public String getShootRoomSchIds() {
        return shootRoomSchIds;
    }

    public void setShootRoomSchIds(String shootRoomSchIds) {
        this.shootRoomSchIds = shootRoomSchIds;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
