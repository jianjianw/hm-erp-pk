package com.qiein.erp.pk.util;

import com.qiein.erp.pk.constant.CommonConstant;
import com.qiein.erp.pk.exception.ExceptionEnum;
import com.qiein.erp.pk.exception.RException;
import com.qiein.erp.pk.web.entity.dto.VerifyParamDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * http工具类
 */
public class HttpUtil {


    /**
     * 从request中获取参数
     *
     * @param param
     * @return
     */
    public static String getRequestParam(HttpServletRequest httpRequest, String param) {
        // 从header中获取参数
        String rParam = httpRequest.getHeader(param);
        // 如果header中不存在，则从参数中获取
        if (StringUtil.isEmpty(rParam)) {
            rParam = httpRequest.getParameter(param);
        }
        return rParam;
    }



    /**
     * 获取http
     *
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取IP地址
     * <p>
     * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-
     * For中第一个非unknown的有效IP字符串，则为真实IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 校验是否是合格IP地址
     *
     * @param ip
     * @return
     */
    public static boolean isIp(String ip) {
        Pattern p = Pattern.compile("^((25[0-5]|2[0-4]\\d|[1]\\d\\d|[1-9]\\d|\\d)($|(?!\\.$)\\.)){4}$");
        return p.matcher(ip).matches();
    }


    /**
     * 把Url  结尾加上 /
     *
     * @param url
     * @return
     */
    public static String formatEndUrl(String url) {
        if (url.endsWith("/")) {
            return url;
        } else {
            return url + "/";
        }
    }


    /**
     * 获取请求的 验证参数
     */
    public static VerifyParamDTO getRequestToken(HttpServletRequest request) {
        String token = HttpUtil.getRequestParam(request, CommonConstant.TOKEN);
        String uid = HttpUtil.getRequestParam(request, CommonConstant.UID);
        String cid = HttpUtil.getRequestParam(request, CommonConstant.CID);
        // 验证参数不全
        if (StringUtil.isEmpty(token) || StringUtil.isEmpty(uid) || StringUtil.isEmpty(cid)) {
            throw new RException(ExceptionEnum.VERIFY_PARAM_INCOMPLETE);
        }
        // 封装验证参数
        VerifyParamDTO verifyParamDTO = new VerifyParamDTO();
        verifyParamDTO.setToken(token);
        // 参数转换失败时
        try {
            verifyParamDTO.setCid(Integer.valueOf(cid));
            verifyParamDTO.setUid(Integer.valueOf(uid));
        } catch (NumberFormatException ignored) {
            ignored.printStackTrace();
            throw new RException(ExceptionEnum.TOKEN_VERIFY_FAIL);
        }
        return verifyParamDTO;
    }
}