package com.pdd.lj.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pdd
 * @date 2019/11/12 下午2:16
 * 扫描mapper文件
 */
@Configuration
public class MybatisConfiguration {

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.pdd.lj.mapper");
        return mapperScannerConfigurer;
    }
}

