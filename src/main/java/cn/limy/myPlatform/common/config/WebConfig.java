package cn.limy.myPlatform.common.config;

import cn.limy.myPlatform.common.interceptor.AccessLimitInterceptor;
import cn.limy.myPlatform.common.interceptor.LoginInterceptor;
import cn.limy.myPlatform.common.interceptor.RefreshTokenInterceptor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mijiupro
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final RefreshTokenInterceptor refreshTokenInterceptor;
    private final LoginInterceptor loginInterceptor;
    private final AccessLimitInterceptor accessLimitInterceptor;



    public WebConfig(RefreshTokenInterceptor refreshTokenInterceptor, LoginInterceptor loginInterceptor, AccessLimitInterceptor accessLimitInterceptor) {
        this.refreshTokenInterceptor = refreshTokenInterceptor;
        this.loginInterceptor = loginInterceptor;
        this.accessLimitInterceptor = accessLimitInterceptor;

    }
    //拦截器公共排除路径设置
    private InterceptorRegistration configureInterceptorPublicExcludePathPatterns(InterceptorRegistry registry, HandlerInterceptor interceptor) {
        return registry.addInterceptor(interceptor)
                // 排除特定业务接口
                .excludePathPatterns("/captcha/**", "/test/**", "/", "/user/login/**","/function-system/**")
                //排除静态资源
                .excludePathPatterns("*.html", "/images/**")
                //排除swagger相关
                .excludePathPatterns("/doc.html","/webjars/**", "/swagger-resources", "/swagger-resources/**", "/v3/**", "/favicon.ico", "Mozilla/**");

    }
    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
//        configureInterceptorPublicExcludePathPatterns(registry, refreshTokenInterceptor).order(0);
//        configureInterceptorPublicExcludePathPatterns(registry, loginInterceptor).order(1);
//        registry.addInterceptor(accessLimitInterceptor).order(2);

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}