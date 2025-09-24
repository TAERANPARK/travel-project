package com.multi.travelproject.domain;

import lombok.Data;

@Data
public class Travel {
    private long no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;
    private Double latitude; //위도
    private Double longitude; //경도
}
