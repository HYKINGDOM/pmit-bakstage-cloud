package com.galaxysoft.project.auth.security.annotation;

import com.galaxysoft.project.auth.security.component.PigResourceServerAutoConfiguration;
import com.galaxysoft.project.auth.security.component.PigSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * 资源服务注解
 * @author Administrator
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({PigResourceServerAutoConfiguration.class, PigSecurityBeanDefinitionRegistrar.class})
public @interface EnablePigResourceServer {

}
