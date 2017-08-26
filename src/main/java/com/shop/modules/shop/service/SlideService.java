package com.shop.modules.shop.service;

import com.shop.common.enums.YesNo;
import com.shop.modules.shop.dao.SlideRepository;
import com.shop.modules.shop.domain.Slide;
import com.shop.modules.shop.domain.enums.SlideType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideService {
    @Autowired
    private SlideRepository slideRepository;

    public List<Slide> homeSlide() {
        return slideRepository.findByTypeEqualsAndIsShowEquals(SlideType.HOME, true);
    }

    public Page<Slide> findFullText(String text, Pageable pageable) {
        return slideRepository.findFullText(text, pageable);
    }

    public Slide save(Slide s) {
        return slideRepository.save(s);
    }

    public void delete(Long id) {
        slideRepository.delete(id);
    }

    public Slide findById(Long id) {
        return slideRepository.findOne(id);
    }
}
