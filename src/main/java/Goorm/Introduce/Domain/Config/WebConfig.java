package Goorm.Introduce.Domain.Config;

import Goorm.Introduce.Web.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // addPathPatterns는 로그인 패턴 적용
    // exclude는 로그인 패턴 적용X -> 일반적으로 들어갈 곳
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/","/member", "/login", "/logout", "/comment/**", "/css/**","/images/**","/js/**","/error")
                .addPathPatterns("/member/add", "/modify/**", "/board/**", "/member/delete");
    }

    // 캐시 타임아웃 설정
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}
