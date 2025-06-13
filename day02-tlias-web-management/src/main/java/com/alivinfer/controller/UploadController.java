package com.alivinfer.controller;

import com.alivinfer.anno.LogOperation;
import com.alivinfer.pojo.Result;
import com.alivinfer.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * @author Fer
 * @version 1.0
 * @description 文件上传处理
 * @date 2025/5/1
 */

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOssOperator;

    // 保存路径设为当前模块下 files 目录
    private static final Path UPLOAD_DIR = Paths.get(System.getProperty("user.dir"), "files");

    @LogOperation
    @PostMapping("/uploadLocal")
    public Result uploadLocal(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("上传失败：文件为空");
        }

        try {
            // 获取原始文件名并生成唯一的新文件名（避免存储）
            String originFileName = file.getOriginalFilename();

            String fileExtension = "";
            if (originFileName.contains(".")) {
                fileExtension = originFileName.substring(originFileName.lastIndexOf("."));
            }

            String newName = UUID.randomUUID() + fileExtension;

            // 构建保存路径
            if (!Files.exists(UPLOAD_DIR)) {
                Files.createDirectories(UPLOAD_DIR);
            }

            Path filePath = UPLOAD_DIR.resolve(newName);

            // 保存文件到本地
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return Result.success();

        } catch (IOException e) {
            log.error("文件上传异常", e);
            return Result.error("上传失败：" + e.getMessage());
        }

    }

    @LogOperation
    @PostMapping("/upload")
    public Result uploadByOss(@RequestParam("file") MultipartFile file) throws Exception {
        log.info("文件上传: {}", file.getOriginalFilename());
        // 将文件交给 OSS 存储管理
        String url = aliyunOssOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传 OSS, url: {}", url);

        return Result.success(url);
    }
}
