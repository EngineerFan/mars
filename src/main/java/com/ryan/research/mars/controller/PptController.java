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

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.sl.usermodel.SlideShowFactory;
import org.apache.poi.xslf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author FXL
 * @description: TODO 请在此添加描述
 * @reason: TODO ADD REASON(可选)
 * @date 2020/8/26 15:49
 * @since JDK 1.8
 */
@RestController
@RequestMapping("ppt")
public class PptController {


    /**
     * 导出经营分析图表为PPT 文件
     *
     * @param request
     * @param response
     * @return void
     * @author FXL
     * @date 2020/8/26 15:28
     */
    @RequestMapping("/export")
    @ResponseBody
    public ResponseEntity<byte[]> exportPPT(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HSLFSlideShow ppt = new HSLFSlideShow();
        HSLFSlide shape = ppt.createSlide();
        String downloadFileName = "demo.ppt";
        File f = new File("" + downloadFileName);
        FileOutputStream out = null;
        try {


            out = new FileOutputStream(f);
            String[][] data = new String[][]{{"输入文件", "记录数"}, {"项目文件", "11,559"}, {"供应商文案", "300"}, {"购买历史记录文件", "10,000"}, {"请购单总数", "10,200,038"}};

            ppt.write(out);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", downloadFileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(FileUtils.readFileToByteArray(f), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}

