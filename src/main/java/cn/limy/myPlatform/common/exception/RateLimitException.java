package cn.limy.myPlatform.common.exception;


import cn.limy.myPlatform.common.enumerate.ResultEnum;
import lombok.Getter;

/**
 * @author mijiupro
 */
@Getter
public class RateLimitException extends RuntimeException{
    private final ResultEnum resultEnum;

    public RateLimitException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
