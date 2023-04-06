package com.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2 //开启swagger2自动配置
public class SwaggerConfig {
    //以下为配置信息，如果不配置，swagger会使用默认配置
    //创建一个swagger的bean实例
    @Bean
    public Docket docket() {
        //通过apiInfo对象配置基本信息
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()) //配置设定的基本信息
                .groupName("book") //配置分组信息：修改组名为 book，多个分组需要多个Docket，一个Docket对应一个分组
                .select().apis(RequestHandlerSelectors.basePackage("com.ws")) //配置接口信息：扫描指定包
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parametersConfig()); //添加请求头信息
    }

    //设定基本信息
    private ApiInfo apiInfo() {

        //作者信息
        Contact contact = new Contact(
                "wangsen",
                "http://www.wangsenblog.top",
                "1376474892@qq.com"
        );

        return new ApiInfoBuilder()
                .title("BookDemo接口文档")
                .description("存储书籍信息的一个实例demo")
                .version("1.0")
                .license("书籍增删改查")
                .licenseUrl("www.wangsenblog.top")
                .contact(contact).build();
    }

    //设置请求头
    public List<Parameter> parametersConfig(){
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(
                new ParameterBuilder().name("token")
                .description("token")
                .modelRef(new ModelRef("String"))
                .parameterType("header")
                .defaultValue("default")
                .hidden(true)
                .required(false)
                .build()

        );
        parameters.add(
                new ParameterBuilder().name("token2")
                        .description("token")
                        .modelRef(new ModelRef("String"))
                        .parameterType("header")
                        .defaultValue("")
                        .hidden(true)
                        .required(false)
                        .build()
        );
        return parameters;
    }


}
