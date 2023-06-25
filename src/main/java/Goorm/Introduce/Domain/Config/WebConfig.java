package Goorm.Introduce.Domain.Config;

import Goorm.Introduce.Web.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/","/member/**","/login","/logout","/css/**","/images/**","/js/**","/error");
    }
}
