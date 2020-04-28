package com.djw.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author djw
 * @Description 页面控制器
 * @Date 2020/4/28 14:59
 */
@Controller
@RequestMapping("view")
public class ViewController {

    @GetMapping("djw")
    public String myPage() {
        return "myPage";
    }
}
