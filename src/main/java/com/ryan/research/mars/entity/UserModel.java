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
package com.ryan.research.mars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FXL
 * @description: TODO 请在此添加描述
 * @reason: TODO ADD REASON(可选)
 * @date 2020/9/7 11:13
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {


    private String username;


    private String registerTime;


    private String city;
}

