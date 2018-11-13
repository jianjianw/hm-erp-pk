package com.qiein.erp.pk.web.entity.dto;


import java.io.Serializable;

public class SceneDTO implements Serializable {
    private static final long serialVersionUID = -2090391419659702910L;

    private Integer id;     //场景id

    private Integer shootId;    //拍摄间id

    private String sceneName;  //场景名字

    private Short sceneStatus;  //场景状态  1 开启  0 关闭

    private Integer priority;   //排序

    private Integer companyId;  //公司id

   /*  <result column="room_name" property="companyId" jdbcType="INTEGER" />
    <result column="venue_id" property="companyId" jdbcType="INTEGER" />
    <result column="venue_name" property="companyId" jdbcType="INTEGER" />
    <result column="base_id" property="companyId" jdbcType="INTEGER" />
*/
}
