package com.djw.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
class ServiceEduApplicationTests {
    @Value("${file.path}")
    private String filePath;

    @Test
    void contextLoads() {
        System.out.println(filePath);
    }

    public static void main(String[] args) {
        System.out.println(Base64.getEncoder().encodeToString("18".getBytes()));
//        String name = new String(Base64.getDecoder().decode("ZGp3"));
//        System.out.println(name);
    }
}
