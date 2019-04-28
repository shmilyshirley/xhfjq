package com.hlframe.xhjq.test;

import com.alibaba.fastjson.JSON;
import com.hlframe.xhjq.domain.HzbsMxsj;
import com.hlframe.xhjq.utils.RegexUtils;

import java.util.List;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2018-12-18 16:48
 */
public class JsonTest {
    public static void main(String[] args) {
//        JsonConvertUtils.jsonToBean()
        String json = "{\n" +
                "  \"totalRecords\": \"6\",\n" +
                "  \"tableList\": [\n" +
                "    {\n" +
                "      \"date\": \"全部\",\n" +
                "      \"name\": \"风景名胜区\",\n" +
                "      \"device_name\": \"全部\",\n" +
                "      \"mark\": \"全部\",\n" +
                "      \"address\": \"全部\",\n" +
                "      \"isWork\": \"全部时间\",\n" +
                "      \"service_item\": \"住房公积金\",\n" +
                "      \"service_itemX\": \"住房情况（无房证明）\",\n" +
                "      \"play_count\": \"1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"全部\",\n" +
                "      \"name\": \"风景名胜区\",\n" +
                "      \"device_name\": \"全部\",\n" +
                "      \"mark\": \"全部\",\n" +
                "      \"address\": \"全部\",\n" +
                "      \"isWork\": \"全部时间\",\n" +
                "      \"service_item\": \"交通出行\",\n" +
                "      \"service_itemX\": \"车辆违法缴款\",\n" +
                "      \"play_count\": \"1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"全部\",\n" +
                "      \"name\": \"风景名胜区\",\n" +
                "      \"device_name\": \"全部\",\n" +
                "      \"mark\": \"全部\",\n" +
                "      \"address\": \"全部\",\n" +
                "      \"isWork\": \"全部时间\",\n" +
                "      \"service_item\": \"交通出行\",\n" +
                "      \"service_itemX\": \"车辆违法查询\",\n" +
                "      \"play_count\": \"1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"全部\",\n" +
                "      \"name\": \"风景名胜区\",\n" +
                "      \"device_name\": \"全部\",\n" +
                "      \"mark\": \"全部\",\n" +
                "      \"address\": \"全部\",\n" +
                "      \"isWork\": \"全部时间\",\n" +
                "      \"service_item\": \"社会保障\",\n" +
                "      \"service_itemX\": \"社保证明\",\n" +
                "      \"play_count\": \"6\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"全部\",\n" +
                "      \"name\": \"风景名胜区\",\n" +
                "      \"device_name\": \"全部\",\n" +
                "      \"mark\": \"全部\",\n" +
                "      \"address\": \"全部\",\n" +
                "      \"isWork\": \"全部时间\",\n" +
                "      \"service_item\": \"社会保障\",\n" +
                "      \"service_itemX\": \"医保参保信息\",\n" +
                "      \"play_count\": \"1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"全部\",\n" +
                "      \"name\": \"风景名胜区\",\n" +
                "      \"device_name\": \"全部\",\n" +
                "      \"mark\": \"全部\",\n" +
                "      \"address\": \"全部\",\n" +
                "      \"isWork\": \"全部时间\",\n" +
                "      \"service_item\": \"市民卡\",\n" +
                "      \"service_itemX\": \"市民卡申领\",\n" +
                "      \"play_count\": \"2\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String stringWithBracket = RegexUtils.getStringWithBracket(json);
        List<HzbsMxsj> hzbsMxsjList = JSON.parseArray(stringWithBracket, HzbsMxsj.class);
        for (HzbsMxsj bean : hzbsMxsjList){
            System.out.println("bean = " + bean);
        }
    }

    private static void jsonToBean(String jsonStr){
        /*---syj
        Map<String,Object> map = JSON.parseObject(jsonStr, Map.class);
        List<Map<String, Object>> tableList = (List<Map<String, Object>>)map.get("tableList");
        for (Map<String,Object> table : tableList){

        }*/
    }
}
