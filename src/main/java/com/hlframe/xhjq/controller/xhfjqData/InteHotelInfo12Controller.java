package com.hlframe.xhjq.controller.xhfjqData;

import com.hlframe.xhjq.service.InteHotelInfo12Service;
import com.hlframe.xhjq.utils.FormatNumberUtils;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 10:41
 */
@RestController
@RequestMapping(value = "inteHotelInfo12")
public class InteHotelInfo12Controller {
    @Autowired
    private InteHotelInfo12Service inteHotelInfo12Service;

    /**
     * 国际TOP9的客流量数据+比例
     * @return
     */
    @RequestMapping(value = "top9")
    public List top9(){
        Map hashMap = new HashMap();
        int totalPeoNum = inteHotelInfo12Service.totalPeoNum();
        List list = inteHotelInfo12Service.top9();

        for (int i = 0;i < list.size();i++){
            hashMap = (Map) list.get(i);
            Integer j = (Integer) hashMap.get("客流量");
            hashMap.put("占比",FormatNumberUtils.numberToFloat(j,totalPeoNum,2));
        }
        return list;
    }
}
