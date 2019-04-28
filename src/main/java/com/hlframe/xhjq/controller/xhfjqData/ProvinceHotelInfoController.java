package com.hlframe.xhjq.controller.xhfjqData;

import com.hlframe.xhjq.service.InteHotelInfoService;
import com.hlframe.xhjq.service.ProvinceHotelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 00:16
 */
@RestController
@RequestMapping(value = "provinceHotelInfo")
public class ProvinceHotelInfoController {
    @Autowired
    private ProvinceHotelInfoService provinceHotelInfoService;

    @RequestMapping(value = "countCustomer")
    public Integer countCustomer(){
        return provinceHotelInfoService.countCustomer();
    }

}
