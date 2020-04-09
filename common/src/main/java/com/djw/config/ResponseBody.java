package com.djw.config;

import com.djw.bean.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.net.URI;

/**
 * @Author djw
 * @Description 统一接口返回处理
 * @Date 2019/12/4 14:23
 */
@ControllerAdvice
public class ResponseBody implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        String path = serverHttpRequest.getURI().toString();
        //有swagger接口文档时
        if (!path.contains("swagger") && !path.contains("v2")) {
            Result result = new Result();
            if (o == null) {
                return result;
            } else if (o instanceof Result) {
                result = (Result) o;
            } else {
                result.data(o);
            }
            // 返回接口数据
            return result;
        }
        return o;
    }
}
