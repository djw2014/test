package com.djw.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author djw
 * @Description swagger接口文档
 * @Date 2020/4/8 14:24
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket swaggerConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // //大标题
                .title("项目API文档")
                // 版本号
                .version("1.0")
                // 描述
                .description("接口说明")
                //作者
                .contact(new Contact("djw", "#", "#"))
//                .license("The Apache License, Version 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
