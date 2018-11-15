package com.qiein.erp.pk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
//扫描DAO包
@MapperScan("com.qiein.erp.pk.web.dao")
//扫描实体类包
@EntityScan("com.qiein.erp.pk.web.entity.*")
//允许发现服务
@EnableDiscoveryClient
//允许远程调用客户端
@EnableFeignClients
public class PkApplication {

    public static void main(String[] args) {
        SpringApplication.run(PkApplication.class, args);
    }
}
