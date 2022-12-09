package com.example.potato_serve.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RequestUtil {

    public static void main(String[] args) {
//        doGet();
        doPost();
    }

    public static Object doGet() {
        String url = "https://www.jianshu.com/shakespeare/jsd/exchange_rates/current";
        Map<String, String> json = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();

        // 设置header
        HttpHeaders headers = new HttpHeaders();
        headers.add("cookie", "123");
        headers.add("Content-Type", "application/json; charset=utf-8");

        // 设置参数
        json.put("status", "1");
        json.put("type", "newTest");

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(json, headers);

//        Map<String, Object> result = (Map<String, Object>) restTemplate.getForEntity(url, Map.class, entity);
        ResponseEntity<JSONObject> result = restTemplate.exchange(url, HttpMethod.GET, entity, JSONObject.class);
        System.out.print(result.getBody());
        System.out.print(result.getBody());

        return null;
    }

    public static Object doPost() {
        String url = "https://www.jianshu.com/shakespeare/notes/0842b888d94a/mark_viewed";
        Map<String, String> json = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();

        // 设置header
        HttpHeaders headers = new HttpHeaders();
        headers.add("cookie", "123");
        headers.add("Content-Type", "application/json; charset=utf-8");

        // 设置参数
        json.put("status", "222");
        json.put("type", "333");

        HttpEntity< Map<String, String>> entity = new HttpEntity<>(json, headers);

        ResponseEntity<JSONObject> result = restTemplate.postForEntity(url, entity, JSONObject.class);
        System.out.print(result);

        return null;
    }
}
