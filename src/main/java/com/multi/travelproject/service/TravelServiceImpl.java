package com.multi.travelproject.service;

import com.multi.travelproject.domain.Travel;
import com.multi.travelproject.mapper.TravelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {
    private final TravelMapper travelMapper;
    public TravelServiceImpl(TravelMapper travelMapper) { this.travelMapper = travelMapper; }

    @Override
    public List<Travel> findPageWithCoords(String q, int size, int offset) {
        return travelMapper.selectPageWithCoords(q, size, offset);
    }

    @Override
    public long countWithCoords(String q) {
        return travelMapper.countWithCoords(q);
    }

    @Override
    public Travel findByNo(Long no) {
        return travelMapper.selectByNo(no);
    }
}
