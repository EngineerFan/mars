package com.ryan.research.mars;

import com.ryan.research.mars.entity.Cat;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @Date 2020-07-08 11:08:01
 * @Description 测试类
 **/
public class CatTest {


    @Test
    public void testReflectMethod() {
        Class clazz = Cat.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.err.println(method.toString());
        }
    }

    @Test
    public void testStringSwitch(){
        String s = "1";
        switch (s) {
            case "1":
                System.err.println(1);
        }
    }

    @Test
    public void test泛型(){
        List<Object> objectList = new ArrayList<>();
        List<?> list = objectList;



    }
}
