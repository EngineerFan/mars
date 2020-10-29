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

import com.ryan.research.mars.entity.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author FXL
 * @description: TODO 请在此添加描述
 * @reason: TODO ADD REASON(可选)
 * @date 2020/9/7 11:10
 * @since JDK 1.8
 */
@RestController
@RequestMapping("v1")
public class DemoController {


    /**
     * 获取用户信息列表
     *
     * @return java.util.List<com.ryan.research.mars.entity.UserModel>
     * @author FXL
     * @date 2020/9/7 11:14
     */
    @GetMapping("/users/list")
    public List<UserModel> getUserList() throws InterruptedException {
        UserModel u1 = new UserModel("fxl", "2020-09-07", "shanghai");
        UserModel u2 = new UserModel("fxl1", "2020-09-07", "shanghai");
        UserModel u3 = new UserModel("fxl2", "2020-09-07", "shanghai");
        List<UserModel> resultList = new ArrayList<>();
        resultList.add(u1);
        resultList.add(u2);
        resultList.add(u3);
        long start = System.currentTimeMillis() / 1000L;
        System.err.println("start: " + start + "s");
        Thread.sleep(1000 * 4000);
        long end = System.currentTimeMillis() / 1000L;
        System.err.println("end  : " + end + "s");
        System.err.println("共耗时: " + (end - start) + "s");
        return resultList;
    }

}

