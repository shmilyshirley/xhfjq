package com.hlframe.xhjq.controller.xhfjqData;

import com.google.common.collect.Lists;
import com.hlframe.xhjq.domain.xhfjqData.Vo;
import com.hlframe.xhjq.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.util.*;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 01:21
 */
@RestController
@RequestMapping(value = "hotelCustomer")
public class HotelCustomerController {
    @Autowired
    private ProvinceHotelInfoService provinceHotelInfoService;
    @Autowired
    private InteHotelInfoService inteHotelInfoService;
    @Autowired
    private InteHotelInfo12Service inteHotelInfo12Service;
    @Autowired
    private ZhejiangHotelInfo12Service zhejiangHotelInfo12Service;
    @Autowired
    private ChinaHotelInfo12Service chinaHotelInfo12Service;
    @Autowired
    private HotelCommentService hotelCommentService;
    /**
     * 计数12月份的客流量
     * @return
     */
    @RequestMapping(value = "countDec")
    public Integer countDec(){
        return inteHotelInfo12Service.countCustomer() + chinaHotelInfo12Service.countCustomer() + zhejiangHotelInfo12Service.countCustomer();
    }

    /**
     * 计数1-11月份的客流量
     * @return
     */
    @RequestMapping(value = "countJanToNov")
    public Integer countJanToNov(){
        return inteHotelInfoService.countCustomer() + provinceHotelInfoService.countCustomer();
    }

    /**
     * 计数全国全年(1-12月份)的客流量(除浙江省)
     * @return
     */
    @RequestMapping(value = "countTotal")
    public Integer countTotal(){
        return inteHotelInfoService.countCustomer() + inteHotelInfo12Service.countCustomer() + chinaHotelInfo12Service.countCustomer() + zhejiangHotelInfo12Service.countCustomer() + provinceHotelInfoService.countCustomer();
    }

    /**
     * 计算全国+国际1-12月份入住率(入住率=入住总人数/房间数)
     * @return
     */
    @RequestMapping(value = "occupancyRate")
    public List occupancyRate(){
        /*Map map = new LinkedHashMap();
        map.put("入住率",(inteHotelInfoService.countCustomer() + inteHotelInfo12Service.countCustomer() + chinaHotelInfo12Service.countCustomer() + zhejiangHotelInfo12Service.countCustomer() + provinceHotelInfoService.countCustomer())/hotelCommentService.countHotel());
        return map;*/
        Map map = new HashMap<String,String>();
        List<Vo> list = inteHotelInfoService.occupancyRate();
        List<Object> arrayList = new ArrayList<>();
        List<Vo> shunxuList = new ArrayList<>();
        // 判断list中是否一共12个月份，少于12个月份，则补全缺少的月份，赋值为0。
        if ( list.size() < 12){
            for ( int i = 0; i < list.size(); i++){
                arrayList.add(list.get(i).getMonth());
            }
//            arrayList = list.stream().map(vo -> vo.getMonth()).collect(Collectors.toList());
            for ( int o = 1; o <= 12; o++ ){
                if (!arrayList.contains(String.valueOf(o))){
                    Vo vo = new Vo();
                    vo.setMonth(String.valueOf(o));
                    vo.setPeo_num(0);
                    list.add(vo);
                }
            }
            //Optional<List<Vo>> optional = Optional.ofNullable(list);
            //List<Vo> voList = optional.orElse(new ArrayList<>());
            //shunxuList = list.stream().sorted(Comparator.comparing(vo -> Integer.parseInt(vo.getMonth()))).collect(Collectors.toList());
//            list.sort(Comparator.comparing(vo -> Integer.parseInt(vo.getMonth())));
        }
        // 遍历list中的Vo对象，对其进行接口数据展示。
        List<Map<String,Object>> resultList = Lists.newArrayList();
        for (Vo v : list){
            Map map2 = new HashMap<String,String>();
            if ( list.size() < 12){
                for ( int i = 0; i < list.size(); i++){
                    arrayList.add(v.getMonth());
                }
            }
            map2.put("month",v.getMonth());
            map2.put("peo_num",v.getPeo_num());
            // 创建一个数值格式化对象
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format(((float) v.getPeo_num() / 232350)*100);
            map2.put("rate",result);
            List list2 = new ArrayList<>();
            resultList.add(map2);
        }
        return resultList;
    }

}