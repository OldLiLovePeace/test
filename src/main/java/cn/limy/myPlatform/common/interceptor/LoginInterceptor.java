package cn.limy.myPlatform.common.interceptor;

import cn.limy.myPlatform.common.enumerate.ResultEnum;
import cn.limy.myPlatform.common.exception.TokenOverdueException;
import cn.limy.myPlatform.common.util.UserHolder;
import cn.limy.myPlatform.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;


/**
 * @author mijiupro
 */

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("进入登录拦截器");
        User user = UserHolder.getInfoByToken();

        if (Objects.isNull(user)) {
            log.info("过期异常");
            throw new TokenOverdueException(ResultEnum.PERMISSION_EXPIRE);
        }

        log.info("放行");
        return true;
    }
}
