package Goorm.Introduce.Domain.Config;

import Goorm.Introduce.Web.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // addPathPatterns는 로그인 패턴 적용
    // exclude는 로그인 패턴 적용X -> 일반적으로 들어갈 곳
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/admin/**","/member/add")
                .excludePathPatterns("/","/member/**", "/login", "/logout", "/comment/**", "/css/**","/images/**","/js/**","/error");
    }
}
