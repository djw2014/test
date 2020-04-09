package com.djw.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.djw.edu.entity.EduTeacher;
import com.djw.edu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author djw
 * @Description 讲师控制器
 * @Date 2020/4/8 14:01
 */
@RestController
@RequestMapping("eduTeacher")
@Api(value = "讲师操作控制器", description = "讲师操作")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("findAll")
    @ApiOperation(value = "查询所有的讲师")
    public List<EduTeacher> findAll() {
        List<EduTeacher> list = eduTeacherService.list();
        int i = 1 / 0;
        return list;
    }

    @GetMapping("findByPage")
    @ApiOperation(value = "分页查询讲师列表")
    public Page<EduTeacher> findByPage(int current, int size) {
        Page<EduTeacher> page = new Page<>(current, size);
        return eduTeacherService.page(page);
    }

    @PostMapping("add")
    @ApiOperation(value = "添加一位讲师")
    public Boolean add(EduTeacher eduTeacher) {
        return eduTeacherService.save(eduTeacher);
    }

}
