package com.ryan.research.mars.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Ryan
 * @Date 2020-07-23 16:53:11
 * @Description 异步容器bean
 **/
@Component
public class AsyncComponent {


    @Async
    public void task() throws InterruptedException {
        while (true) {
            System.err.println(Thread.currentThread().getName()+" running async task ... ");
            Thread.sleep(1000);
        }
    }

}
