package com.djw.config;

import com.djw.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author djw
 * @Description 统一异常返回
 * @Date 2020/4/9 13:56
 */
@ControllerAdvice
public class MyExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result commonException(Exception e) {
        logger.error("服务器内部异常", e);
        Result result = Result.error();
        result.setMessage("服务器内部异常");
        return result;
    }
}
