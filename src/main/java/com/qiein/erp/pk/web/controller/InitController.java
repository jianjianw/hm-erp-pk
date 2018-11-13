package com.qiein.erp.pk.web.controller;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.exception.ExceptionEnum;
import com.qiein.erp.pk.exception.RException;
import com.qiein.erp.pk.util.HttpUtil;
import com.qiein.erp.pk.web.entity.dto.RequestInfoDTO;
import com.qiein.erp.pk.web.entity.po.StaffPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * 初始化 Controller
 */
public class InitController {

    @Autowired
    private HttpServletRequest request;

    /**
     * 系统启动
     *
     * @return
     */
    @RequestMapping("/")
    public String initSys() {
        return "jupiter is running success!";
    }

    /**
     * 获取当前登录IP
     */
    @GetMapping("/ip")
    String getIp() {
        return HttpUtil.getIpAddr(request);
    }

    /**
     * 获取session参数
     *
     * @param attrName
     * @return
     */
    Object getSessionAttr(String attrName) {
        return request.getSession().getAttribute(attrName);
    }

    /**
     * 设置Session参数
     *
     * @param attrName
     * @param obj
     */
    void setSessionAttr(String attrName, Object obj) {
        request.getSession().setAttribute(attrName, obj);
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    StaffPO getCurrentLoginStaff() {
        StaffPO attribute = (StaffPO) request.getAttribute(CommonConstant.CURRENT_LOGIN_STAFF);
        if (attribute == null) {
            throw new RException(ExceptionEnum.CAN_NOT_FIND_USER_FROM_REQ);
        }
        return attribute;
    }

    /**
     * 判断请求是否PC
     */
    boolean isPc() {
        boolean isPc = true;
        String s1 = request.getHeader("user-agent");
        if (s1.contains("Android")) {
//            System.out.println("Android移动客户端");
            isPc = false;
        } else if (s1.contains("iPhone")) {
//            System.out.println("iPhone移动客户端");
            isPc = false;
        } else if (s1.contains("iPad")) {
//            System.out.println("iPad客户端");
            isPc = false;
        }
        return isPc;
    }

    /**
     * 获取当前登录信息
     */
    RequestInfoDTO getRequestInfo() {
        return (RequestInfoDTO) request.getAttribute(CommonConstant.REQUEST_INFO);
    }
}
