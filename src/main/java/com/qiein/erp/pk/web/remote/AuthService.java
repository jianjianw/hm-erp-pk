package com.qiein.erp.pk.web.remote;

import com.qiein.erp.pk.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  远程认证服务
 */
@FeignClient(name = "service-auth",configuration = FeignConfiguration.class)
@RequestMapping("/auth")
public interface AuthService {

    @GetMapping(value = "/test")
    String hello(@RequestParam(value = "name") String name);
}
