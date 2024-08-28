package cn.limy.myPlatform.common.exception;

import cn.limy.myPlatform.common.enumerate.ResultEnum;
import lombok.Getter;

/**
 * 令牌过期异常
 *
 * @author mijiupro
 */
@Getter
public class TokenOverdueException extends RuntimeException {
    private final ResultEnum resultEnum;
    public TokenOverdueException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}