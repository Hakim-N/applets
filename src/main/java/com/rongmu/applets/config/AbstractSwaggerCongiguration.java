package com.rongmu.applets.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSwaggerCongiguration {
    private String title;
    private String description;
    private String serviceUrl;
    private String version;

    public AbstractSwaggerCongiguration() {
    }

    @Bean
    public Docket createRestApi() {
        return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(this.apiInfo()).select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any()).build().securityContexts(Lists.newArrayList(new SecurityContext[]{this.securityContext()})).securitySchemes(this.securitySchemes());
    }

    protected List<ApiKey> securitySchemes() {
        List<ApiKey> keys = new ArrayList();
        keys.add(new ApiKey("Authorization", "Authorization", "header"));
        return keys;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(this.defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        return Lists.newArrayList(new SecurityReference[]{new SecurityReference("BearerToken", authorizationScopes)});
    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title(this.getTitle()).description(this.getDescription()).termsOfServiceUrl(this.getServiceUrl()).version(this.getVersion()).build();
    }

    protected abstract String getTitle();

    protected abstract String getDescription();

    protected abstract String getServiceUrl();

    protected abstract String getVersion();
}
