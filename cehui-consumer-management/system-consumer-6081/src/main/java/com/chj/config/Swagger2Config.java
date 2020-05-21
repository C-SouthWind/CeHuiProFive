package com.chj.config;

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

import static com.chj.staticstatus.RequestURLProperties.PACKAGE_CONTROLLER_URL;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 19:37
 * @params :
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()//选择swagger具体生效的接口是什么？(service, controller, mapper)
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER_URL))
                .paths(PathSelectors.any())
                .build();
    }

    /** 方法描述
    * @Description: 构建了整个项目的一些描述信息
    * @Param: []
    * @return: springfox.documentation.service.ApiInfo
    * @Author: chj
    * @Date: 2020/5/15
    */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("测绘管理系统")
                .description("某市的测绘管理系统")
                .contact(new Contact("chj","http://www.chj.com","chj15139530908@Gmail.com"))
                .version("1.0")
                .build();
    }
}




























