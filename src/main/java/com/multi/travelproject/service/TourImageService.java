package com.multi.travelproject.service;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class TourImageService {
    private final String serviceKey = "a4401d8a88e128c93a0b07de2607c9cc6bc052260ba07d46f2621555d17e9625";

    public String getImageUrl(String keyword) {
        try {
            String urlStr = "http://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1"
                    + "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")
                    + "&keyword=" + URLEncoder.encode(keyword, "UTF-8")
                    + "&MobileOS=ETC&MobileApp=AppTest&_type=json&numOfRows=1&pageNo=1";

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(urlStr, String.class);

            JSONObject json = new JSONObject(result);
            JSONArray items = json.getJSONObject("response")
                    .getJSONObject("body")
                    .getJSONObject("items")
                    .getJSONArray("item");

            if(items.length() > 0) {
                return items.getJSONObject(0).getString("galWebImageUrl");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

