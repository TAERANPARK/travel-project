package com.multi.travelproject.dao;

import com.multi.travelproject.domain.Travel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TravelDAO {
    @Select("SELECT no, district, title, description, address, phone, latitude, longitude FROM travel")
    List<Travel> selectAll();
}
