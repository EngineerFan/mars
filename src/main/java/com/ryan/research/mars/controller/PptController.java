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
import org.apache.poi.hslf.model.PPGraphics2D;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.PictureShape;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.print.ProxyPrintGraphics;

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
        HSLFSlide slide1 = ppt.createSlide();
        HSLFSlide slide2 = ppt.createSlide();
        String downloadFileName = "demo.ppt";
        File f = new File("C:\\Users\\admin\\Desktop\\PPT导出功能试验\\" + downloadFileName);
        FileOutputStream out = null;
        try {
            //1. slide properties

            //2. slide component properties
            HSLFTextBox textBox = new HSLFTextBox();
            textBox.setText("Hello World! ");
            textBox.setAnchor(new Rectangle(0, 0, 300, 50));

            HSLFTextParagraph paragraph = textBox.getTextParagraphs().get(0);
            paragraph.setTextAlign(TextParagraph.TextAlign.CENTER);

            HSLFTextRun rt = paragraph.getTextRuns().get(0);
            rt.setBold(true);
            rt.setFontColor(Color.BLUE);
            rt.setUnderlined(true);
            rt.setFontFamily("Arial");
            rt.setItalic(true);

            //绘制图像
            HSLFGroupShape groupShape = new HSLFGroupShape();
            Rectangle bounds = new Rectangle(200, 100, 350, 300);

            groupShape.setAnchor(bounds);
            slide1.addShape(groupShape);

            Object[] def = new Object[]{
                    Color.yellow, new Integer(100),
                    Color.green, new Integer(150),
                    Color.gray, new Integer(75),
                    Color.red, new Integer(200),
            };
            Graphics2D graphics2D = new PPGraphics2D(groupShape);
            int x = bounds.x + 50, y = bounds.y + 50;
            graphics2D.setFont(new Font("Arial", Font.BOLD, 10));
            for (int i = 0, idx = 1; i < def.length; i += 2, idx++) {
                graphics2D.setColor(Color.black);
                int width = ((Integer) def[i + 1]).intValue();
                graphics2D.drawString("Q" + idx, x - 20, y + 20);
                graphics2D.drawString(width + "%", x + width + 10, y + 20);
                graphics2D.setColor((Color) def[i]);
                graphics2D.fill(new Rectangle(x, y, width, 30));
                y += 40;
            }
            graphics2D.setColor(Color.black);
            graphics2D.setFont(new Font("Arial", Font.BOLD, 14));
            graphics2D.draw(bounds);
            graphics2D.drawString("Performance", x + 70, y + 40);


            slide1.addShape(textBox);

            //设置slide2:
            System.err.println(ppt.getPageSize().width);
            System.err.println(ppt.getPageSize().height);
            HSLFPictureData pd = ppt.addPicture(new File("C:\\Users\\admin\\Desktop\\demo.png"), PictureData.PictureType.PNG);
            HSLFPictureShape pictureShape = new HSLFPictureShape(pd);
            pictureShape.setAnchor(new Rectangle(100, 100, 600, 400));
            slide2.addShape(pictureShape);

            out = new FileOutputStream(f);

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

