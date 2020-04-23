package com.djw.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceEduApplicationTests {
    @Value("${file.path}")
    private String filePath;

    @Test
    void contextLoads() {
        System.out.println(filePath);
    }
}
