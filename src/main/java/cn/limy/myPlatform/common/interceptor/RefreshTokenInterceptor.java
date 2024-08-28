package cn.limy.myPlatform.common.interceptor;


import cn.hutool.json.JSONUtil;
import cn.limy.myPlatform.common.util.JwtUtils;
import cn.limy.myPlatform.common.util.UserHolder;
import cn.limy.myPlatform.entity.User;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author mijiupro
 */
@Slf4j
@Component
public class RefreshTokenInterceptor implements HandlerInterceptor {

    private final JwtUtils jwtUtils;
    private final StringRedisTemplate stringRedisTemplate;

    public RefreshTokenInterceptor(JwtUtils jwtUtils, StringRedisTemplate stringRedisTemplate) {
        this.jwtUtils = jwtUtils;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("进入刷新token拦截器");
        // 1、从请求头中获取token
        String authorizationHeader = request.getHeader("authorization");
        if (StringUtils.isBlank(authorizationHeader)) {
            return true;
        }
        // 2.解析token
        Claims claims;
        try{
            claims = jwtUtils.parseToken(authorizationHeader);
            if (Objects.isNull(claims)) {
                return true;
            }
        }catch (Exception e){
            return true;

        }

        // 3.获取用户信息
        Integer userId = claims.get("userId", Integer.class);

        String userInfoJson = stringRedisTemplate.opsForValue().get("login:user:" + userId);
        if (StringUtils.isBlank(userInfoJson)) {
            return true;
        }


        // 4.刷新token
        String refreshToken = jwtUtils.refreshToken(authorizationHeader);

        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Authorization", refreshToken);
        stringRedisTemplate.expire("login:user:" + userId, 30, TimeUnit.MINUTES);

        // 5.将用户信息存入本地线程方便获取
        User user = JSONUtil.toBean(userInfoJson, User.class);
        UserHolder.setInfoByToken(user);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        // 清理本地线程
        UserHolder.clear();
    }
}
