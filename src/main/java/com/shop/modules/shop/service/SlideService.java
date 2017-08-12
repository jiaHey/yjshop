package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.SlideRepository;
import com.shop.modules.shop.domain.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideService {
    @Autowired
    private SlideRepository slideRepository;

    public List<Slide> homeSlide() {
        return slideRepository.findAll();
    }
}
