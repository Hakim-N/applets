
package com.rongmu.applets.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration extends AbstractSwaggerCongiguration {

    @Override
    protected String getTitle() {
        return "RongMu applets API";
    }

    @Override
    protected String getDescription() {
        return "<div style='font-size:14px;color:red;'>applets API</div>";
    }

    @Override
    protected String getServiceUrl() {
        return null;
    }

    @Override
    protected String getVersion() {
        return "1.0";
    }
}
