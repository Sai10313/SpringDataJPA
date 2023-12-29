package com.planmagn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfig.class})
@ComponentScan(basePackages = {"com.planmagn.service"})
public class RootConfig {
}
