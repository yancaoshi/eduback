package com.lecode.eduback.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lecode.eduback.mapper")
public class MabatisPlusConfig {
}
