package com.webFramework.lectures.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class UnicodeTest {

    @Test
    public void unicodeTest() {
        try {
            String name = "IT∙프로그래밍";
            System.out.println(name);
            String utf8 = new String(name.getBytes("UTF-8"));
            String utf16 = new String(name.getBytes("UTF-16"));
            System.out.println(utf8);
            System.out.println(utf16);
            System.out.println(new String(name.getBytes(StandardCharsets.UTF_8)));
            System.out.println();
            System.out.println(URLEncoder.encode(name, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
