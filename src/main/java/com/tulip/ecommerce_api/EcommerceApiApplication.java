package com.tulip.ecommerce_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.tulip.ecommerce_api")
@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages = "com.tulip.ecommerce_api.repository")
@EnableCaching
@EnableScheduling
@Theme("my-theme")
public class EcommerceApiApplication implements AppShellConfigurator {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApiApplication.class, args);
    }
}
