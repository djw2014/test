package com.djw.edu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author djw
 * @Description //TODO
 * @Date 2020/4/28 10:45
 */
@RestController
@RequestMapping("test")
@Api(value = "aop测试")
public class AopTestController {

    @GetMapping("getTest")
    @ApiOperation(value = "")
    public void test(String name, int age, String desc, int len) {
        System.out.println("name:" + name + "--age:" + age + "--desc:" + desc + "--len:" + len);
    }
}
