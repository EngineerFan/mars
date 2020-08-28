/**
 * Copyright (c) 2019, ShangHai YTO Co., Ltd.
 * All right reserved.
 * <p>
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF YTO
 * CO., LTD.  THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED
 * TO THIRD PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 * WITHOUT THE PRIOR WRITTEN PERMISSION OF YTO
 * CO., LTD.
 */
package com.ryan.research.mars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FXL
 * @description: TODO 请在此添加描述
 * @reason: TODO ADD REASON(可选)
 * @date 2020/8/6 10:56
 * @since JDK 1.8
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    private static final String UPLOAD_DIR = "C:\\Users\\admin\\Desktop\\upload_demo\\";

    @RequestMapping("upload")
    public Map<String, Object> excelUpload(@RequestParam(value = "excelFiles", required = false) MultipartFile excelFiles) throws Exception {
        Map<String, Object> result = new HashMap<>();
        if (excelFiles == null || excelFiles.isEmpty()) {
            result.put("code", -1);
            return result;
        }
        String fileName = excelFiles.getOriginalFilename();
        File dest = new File(UPLOAD_DIR + fileName);
        excelFiles.transferTo(dest);
        System.err.println("上传成功");
        result.put("code", 0);
        return result;
    }
}

