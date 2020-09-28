package com.ryan.research.mars;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

//@SpringBootTest
class MarsApplicationTests {

    @Test
    void contextLoads() {
    }


    String json = "{\n" +
            "  \"name\":\"fxl\",\n" +
            "  \"age\":27\n" +
            "\n" +
            "}";



    @Test
    public void 测试Runtime内存大小(){
        Runtime rt = Runtime.getRuntime();
        System.err.println(rt.freeMemory());
        System.err.println(rt.totalMemory());
        System.err.println(rt.maxMemory());
    }

    @Test
    public void 测试Network地址() throws SocketException {
        Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        while (allNetInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration addresses = networkInterface.getInetAddresses();
            while (addresses.hasMoreElements()){
                InetAddress ip = (InetAddress) addresses.nextElement();
                System.err.println(ip.getHostAddress());
            }
        }

    }

}
