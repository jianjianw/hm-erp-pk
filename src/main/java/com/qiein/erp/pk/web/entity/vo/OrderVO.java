package com.qiein.erp.pk.web.entity.vo;

public class OrderVO {
    private Integer id;//编号
    private String orderTime;//订单时间
    private String  shootTime;//拍摄时间
    private String planTime;//企划时间
    private String  kzPhone;//客资电话
    private String  kzName;//客资姓名
    private String  mateName;//配偶姓名
    private String  matePhone;//配偶电话
    private String address;//地址
    private Integer  venueId;//场馆id
    private Integer mealId;//套餐id
    private String mealName;//套餐名称
    private Integer orderType;//订单类型
    private Integer shootId;//摄影师id
    private String  shootName;//摄影师名称
    private Integer makeupId;//化妆师id
    private String makeupName;//化妆师名称
    private String shootRoomId;//拍摄间id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getShootTime() {
        return shootTime;
    }

    public void setShootTime(String shootTime) {
        this.shootTime = shootTime;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public String getKzPhone() {
        return kzPhone;
    }

    public void setKzPhone(String kzPhone) {
        this.kzPhone = kzPhone;
    }

    public String getKzName() {
        return kzName;
    }

    public void setKzName(String kzName) {
        this.kzName = kzName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getShootId() {
        return shootId;
    }

    public void setShootId(Integer shootId) {
        this.shootId = shootId;
    }

    public String getShootName() {
        return shootName;
    }

    public void setShootName(String shootName) {
        this.shootName = shootName;
    }

    public Integer getMakeupId() {
        return makeupId;
    }

    public void setMakeupId(Integer makeupId) {
        this.makeupId = makeupId;
    }

    public String getMakeupName() {
        return makeupName;
    }

    public void setMakeupName(String makeupName) {
        this.makeupName = makeupName;
    }

    public String getShootRoomId() {
        return shootRoomId;
    }

    public void setShootRoomId(String shootRoomId) {
        this.shootRoomId = shootRoomId;
    }
}
