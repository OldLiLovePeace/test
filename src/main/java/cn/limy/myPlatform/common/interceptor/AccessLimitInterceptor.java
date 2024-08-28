package cn.limy.myPlatform.common.interceptor;


import cn.limy.myPlatform.common.annotation.AccessLimit;
import cn.limy.myPlatform.common.enumerate.ResultEnum;
import cn.limy.myPlatform.common.exception.RateLimitException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 接口限流拦截器
 * @author mijiupro
 */
@Slf4j
@Component
public class AccessLimitInterceptor implements HandlerInterceptor {

    private final StringRedisTemplate redisTemplate;

    public AccessLimitInterceptor(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler)  {
        log.info("进入限流拦截器");
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }
        Method method = handlerMethod.getMethod();
        AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);
        // 若方法上没有AccessLimit注解，直接放行
        if (accessLimit == null) {
            return true;
        }
        log.info("执行限流逻辑");
        int limit = accessLimit.limit();
        int seconds = accessLimit.seconds();
        String key = generateKey(request); // 生成限流key

        // 使用基本类型long接收计数值，并确保不会因自动装箱产生NullPointerException
        Long countResult = redisTemplate.opsForValue().increment(key, 1);
        long currentCount = countResult != null ? countResult : 0;
        if (currentCount == 1) {
            // 如果是第一次访问，设置过期时间
            redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            log.debug("设置访问限制计数为1：{}", key);
            return true;
        }

        if (currentCount > limit) {
            log.error("访问超过限制：{}", key);
            throw new RateLimitException(ResultEnum.ACCESS_LIMIT_REACHED);
        }

        log.debug("访问限制计数递增：{}", key);
        return true;
    }

    private String generateKey(HttpServletRequest request) {
        // 组合key的方式可以根据实际业务需要调整，例如考虑方法名称、用户ID等
        return request.getRemoteAddr() + ":" + request.getContextPath() + ":" + request.getServletPath();
    }


}