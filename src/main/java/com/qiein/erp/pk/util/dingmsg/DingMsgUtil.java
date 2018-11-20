package com.qiein.erp.pk.util.dingmsg;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-auth", url = "https://oapi.dingtalk.com/")
@RequestMapping("/robot")
public interface DingMsgUtil {

    @PostMapping("/send?access_token=c13a09ea46c61bbd389c52265316e5cd3743ef628293bd2d7452815c0941c4cb")
    void postMsg(@RequestBody JSONObject jsonObject);
}
