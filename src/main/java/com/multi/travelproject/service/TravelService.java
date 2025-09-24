package com.multi.travelproject.service;

import com.multi.travelproject.domain.Travel;

import java.util.List;

public interface TravelService {
    List<Travel> findPageWithCoords(String q, int size, int offset);
    long countWithCoords(String q);
    Travel findByNo(Long no);
}
