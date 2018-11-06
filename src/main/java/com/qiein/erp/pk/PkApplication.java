package com.qiein.erp.pk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//扫描DAO包
@MapperScan("com.qiein.erp.pk.web.dao")
//扫描实体类包
@EntityScan("com.qiein.erp,pk.web.entity.*")
public class PkApplication {

    public static void main(String[] args) {
        SpringApplication.run(PkApplication.class, args);
    }
}
