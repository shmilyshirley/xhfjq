package com.hlframe.xhjq.utils;

import java.text.DecimalFormat;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-12 11:58
 */
public class FormatNumberUtils {

    /**
     * 两整数数相除保留小数
     * @param num_1 被除数
     * @param num_2 除数
     * @param offset 保留几位小数
     * @return
     */
    public static String numberToFloat(Integer num_1,Integer num_2,int offset){
        StringBuilder pattern = null;
        pattern = new StringBuilder("0.");
        float num = (float) num_1 / num_2;
        for (int i = 0; i < offset; i++ ){
            pattern.append(0);
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());//保留2位小数
        return df.format(num);
    }

    /**
     * 两小数相除保留小数
     * @param num_1 被除数
     * @param num_2 除数
     * @param offset 保留几位小数
     * @return
     */
    public static String numberToFloat2(Float num_1,Float num_2,int offset){
        StringBuilder pattern = null;
        pattern = new StringBuilder("0.");
        float num = (float) num_1 / num_2;
        for (int i = 0; i < offset; i++ ){
            pattern.append(0);
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());//保留2位小数
        return df.format(num);
    }
}
