package com.example.potato_serve.controller;

import com.example.potato_serve.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/")
//@ApiIgnore
public class HomeController {

    @Resource
    private HomeService homeService;

    public static void main(String[] args) throws Exception {
        /*Integer i1 = 199;
        Integer i2 = 199;

        Integer i3 = 125;
        Integer i4 = 125;
        System.out.print(i1 == i2);
        System.out.print(i3 == i4);*/

        int a = 0;
        System.out.print(a);
    }

    public static int test(int x) throws Exception {

        try {
            x = 1;
//            return x;
        } catch (Exception e) {
            x = 2;
//            return x;
        } finally {
            x = 3;
        }

        return x;
    }

    @GetMapping("test")
    public String home(@RequestHeader String Accept) {
//        System.out.print(Accept);
        log.info("Accept: {}", Accept);

        // 模板字符串
        String msg = String.format("%s, %b, %f, %d", "123", false, 8.888, 123);
        log.info("msg: {}", msg);

        // 数组
        List<String> arr = new ArrayList<String>();
        arr.add("test");
        arr.add("test2");
        List<Boolean> booleans = arr
                .stream()
                .map(a -> Boolean.getBoolean(a))
                .collect(Collectors.toList());

        log.info("String: {}", arr);
        log.info("Boolean: {}", booleans);
        log.error("timestamp: {}", System.currentTimeMillis());

        return "test home";
    }

    @GetMapping("testKafka")
    public boolean testKafka() {
        homeService.sendMsg();
        return true;
    }
}
