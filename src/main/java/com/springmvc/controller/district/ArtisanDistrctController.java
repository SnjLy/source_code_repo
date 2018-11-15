package com.springmvc.controller.district;

import com.springmvc.model.district.ArtisanDistrictInfo;
import com.springmvc.service.serviceImpl.ArtisanDistrictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.springmvc.controller.district
 * @Description:  解析手艺人地址，在地图标注手艺人分布信息
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/18.
 */
@RestController
@RequestMapping("/artisan")
public class ArtisanDistrctController {

    private static Map<String, ArtisanDistrictInfo> artisanMap = new HashMap<>();

    @Autowired
    private ArtisanDistrictServiceImpl artisanDistrictService;

    @RequestMapping("/start")
    public ModelAndView toArtisanDistrct(){
        ModelAndView model = new ModelAndView();

        List<ArtisanDistrictInfo> artisans = artisanDistrictService.selectAll(null);

        model.addObject("artisans", artisans);

        model.setViewName("district/artisanDistrict");
        return model;
    }
}
