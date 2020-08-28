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
package com.ryan.research.mars;



import org.junit.Test;

import java.time.LocalDate;

/**
 * @author FXL
 * @description: TODO 请在此添加描述
 * @reason: TODO ADD REASON(可选)
 * @date 2020/8/24 16:04
 * @since JDK 1.8
 */
public class DemoTest {


    @Test
    public void 测试LocalDate() {
        String dateString = "202008";
        System.err.println( Integer.valueOf(dateString.substring(4, 6)));
        LocalDate localDate = LocalDate.of(2020,1,1);
        LocalDate lastDate = localDate.minusMonths(1);
        System.err.println(lastDate);
    }
}

