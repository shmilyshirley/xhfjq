package com.hlframe.xhjq.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

/**
 * json转换为javaBean对象
 */
public class JsonConvertUtils {

    private static Gson gson = null;

    public static <T>List jsonToBean (Class<T> clazz,String json) {
        List<T> list = null;
        gson = new Gson();
        T t = null;
        try {
            t = clazz.newInstance();
            list = new ArrayList<T>();
            // 当json字段不为空的时候，转化为javaBean
            if (json != null){
                json = RegexUtils.getStringWithBracket(json);
                String replace = json.replace("},{", "}--{");
                String[] jsonStringArrays = replace.split("\\-\\-");
                // 遍历字符串数组
                for (String bean : jsonStringArrays){
                    t = gson.fromJson(bean, clazz);
                    // 将javaBean对象存入list集合中
                    list.add(t);
//                System.out.println(list.toString());
                }
            } else {
                log("Json的值为空或者接口获取数据失败 ");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

}
