package com.shop;

import com.shop.common.enums.YesNo;
import com.shop.modules.shop.dao.SlideRepository;
import com.shop.modules.shop.domain.Slide;
import com.shop.modules.shop.domain.enums.SlideType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testSlide {
    @Autowired
    private SlideRepository slideRepository;
    @Test
    public void home(){
        slideRepository.findByTypeEqualsAndIsShowEquals(SlideType.HOME,true);
    }
}
