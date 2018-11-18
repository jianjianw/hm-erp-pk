package com.qiein.erp.pk.web.entity.po;

/**
 * 订单修改编辑po
 * author ：xiangliang
 */
public class OrderEditPO {
    private Integer orderId;//订单id
    private String kzName;//客资姓名
    private String kzPhone;//客资电话
    private String mateName;//配偶姓名
    private String matePhone;//配偶电话
    private Integer srcType;//渠道类型
    private String address;//地址
    private Integer companyId;
    private String childName;//孩子姓名
    private Integer type;//拍摄类型
    private Integer age;//年龄
    private Integer sex;//性别
    private String birthday;//生日
    private String marryTime;//婚期
    private Integer saleId;//销售id
    private String orderTime;//订单时间
    private String orderMemo;//订单备注

    public String getOrderMemo() {
        return orderMemo;
    }

    public void setOrderMemo(String orderMemo) {
        this.orderMemo = orderMemo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMarryTime() {
        return marryTime;
    }

    public void setMarryTime(String marryTime) {
        this.marryTime = marryTime;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }
}
