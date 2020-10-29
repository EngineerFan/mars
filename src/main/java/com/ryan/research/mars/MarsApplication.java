package com.ryan.research.mars;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication
public class MarsApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MarsApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Transaction t = Cat.newTransaction("test","test");
//        try {
//            Cat.logEvent("URL.Server", "必杀", Event.SUCCESS, "ip=127.0.0.1  &...");
//            Cat.logMetricForCount("OrderCount");
//            Cat.logMetricForDuration("KeyForTimer", 5);
//
//            System.err.println("my business...");
//
//            t.setStatus(Transaction.SUCCESS);
//
//        } catch (Exception e) {
//            t.setStatus(e);
//        } finally {
//            t.complete();
//        }
    }
}
