package com.multi.travelproject.controller;

import com.multi.travelproject.domain.Travel;
import com.multi.travelproject.service.TourImageService;
import com.multi.travelproject.service.TravelService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/travels")
public class TravelApiController {

    private final TravelService travelService;
    private final TourImageService imageService;

    public TravelApiController(TravelService travelService, TourImageService imageService) {
        this.travelService = travelService;
        this.imageService  = imageService;
    }

    // 목록(검색/페이징)
    @GetMapping
    public Map<String, Object> list(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(required = false) String q) {

        List<Travel> content = travelService.findPageWithCoords(q, size, (page - 1) * size);
        long total = travelService.countWithCoords(q);
        return Map.of("content", content, "total", total, "page", page, "size", size);
    }

    // 상세: DB + 이미지 URL 합치기
    @GetMapping("/{no}")
    public Map<String, Object> detail(@PathVariable Long no) {
        Travel dto = travelService.findByNo(no);
        String imageUrl = (dto != null) ? imageService.getImageUrl(dto.getTitle()) : null;

        Map<String, Object> result = new HashMap<>();
        result.put("travel", dto);
        result.put("image", imageUrl != null ? imageUrl : "/img/default.jpg");
        return result;
    }

}