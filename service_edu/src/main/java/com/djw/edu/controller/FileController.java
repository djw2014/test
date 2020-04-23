package com.djw.edu.controller;

import com.djw.bean.Result;
import com.djw.edu.entity.SysFile;
import com.djw.edu.service.SysFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author djw
 * @Description 文件操作类
 * @Date 2020/4/23 14:34
 */
@RequestMapping("file")
@RestController
@Api(value = "文件操作", description = "文件的上传、下载、预览")
public class FileController {
    /**
     * 文件目录
     */
    @Value("${file.path}")
    private String directory;
    @Autowired
    private SysFileService sysFileService;

    @PostMapping("upload")
    @ApiOperation(value = "文件上传")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return Result.error().setMessage("file is empty!");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        //文件名
        String fileName = file.getOriginalFilename();
        //文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        //以上传时间创建当天的文件夹
        String time = format.format(new Date());
        File dest = new File(directory + File.separator + time + File.separator + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        SysFile sysFile = new SysFile();
        sysFile.setFileName(fileName);
        sysFile.setSuffix(suffix);
        sysFile.setAddress(dest.getAbsolutePath());
        if (sysFileService.save(sysFile)) {
            return Result.ok().setData(sysFile.getId());
        }else {
            dest.deleteOnExit();
            return Result.error().setMessage("file upload fail!");
        }
    }

    @GetMapping("preview")
    @ApiOperation(value = "文件预览")
    public void preview(String fileId, HttpServletResponse response) throws IOException {
        SysFile sysFile = sysFileService.getById(fileId);
        File file = new File(sysFile.getAddress());
        byte[] bytes = Files.readAllBytes(file.toPath());
        if (!file.exists() || bytes.length == 0) {
            response.sendError(404);
            return;
        }
        response.addHeader("Content-Disposition", " inline ");
        response.addHeader("Content-Length", "" + bytes.length);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    @GetMapping("download")
    @ApiOperation(value = "文件下载")
    public void download(String fileId, HttpServletResponse response) throws IOException {
        SysFile sysFile = sysFileService.getById(fileId);
        File file = new File(sysFile.getAddress());
        byte[] bytes = Files.readAllBytes(file.toPath());
        if (!file.exists() || bytes.length == 0) {
            response.sendError(404);
            return;
        }
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(sysFile.getFileName(), "UTF-8"));
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
}
