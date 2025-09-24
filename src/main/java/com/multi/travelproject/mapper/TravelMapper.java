package com.multi.travelproject.mapper;

import com.multi.travelproject.domain.Travel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelMapper {
    List<Travel> selectPageWithCoords(@Param("q") String q,
                                      @Param("size") int size,
                                      @Param("offset") int offset);
    long countWithCoords(@Param("q") String q);
    Travel selectByNo(@Param("no") Long no);
}
