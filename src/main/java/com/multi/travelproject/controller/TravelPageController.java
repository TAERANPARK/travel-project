package com.multi.travelproject.controller;

import com.multi.travelproject.domain.Travel;
import com.multi.travelproject.service.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/travels")
public class TravelPageController {
    private final TravelService service;


    public TravelPageController(TravelService service) {
        this.service = service;
    }

    @GetMapping
    public String list(@RequestParam(defaultValue="1") int page,
                       @RequestParam(defaultValue="10") int size,
                       @RequestParam(required=false) String q,
                       Model model){
        int p = Math.max(page,1), s = Math.min(Math.max(size,1),50), offset = (p-1)*s;
        List<Travel> rows = service.findPageWithCoords(q, s, offset);
        long total = service.countWithCoords(q);
        long last = Math.max(1, (long)Math.ceil((double)total/s));
        model.addAttribute("rows", rows);
        model.addAttribute("page", p);
        model.addAttribute("size", s);
        model.addAttribute("last", last);
        model.addAttribute("total", total);
        model.addAttribute("q", q);
        return "/list";
    }

}

