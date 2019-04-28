package com.hlframe.xhjq.test;

import com.hlframe.xhjq.utils.EncodeUtils;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-01-08 15:29
 */
public class EncodingTest {
    public static void main(String[] args) {


        String string = "hahahuhu呼呼";
        String base32 = EncodeUtils.EncodeByBASE32(string.getBytes());
        System.out.println("base32 = " + base32);

/*
        byte[] inputData = "辣鸡狗Iloceyou".getBytes();
        BigInteger md5 = new BigInteger(EncodeUtils.encryptMD5(inputData));
        System.out.println(md5.toString());
*/

        String base321 = EncodeUtils.EncodeByBASE32("hahahuhu呼呼".getBytes());
        System.out.println("base321 = " + base321);

        String fengjing = EncodeUtils.URLEncode("风景");
        System.out.println("fengjing = " + fengjing);

        String url = EncodeUtils.EncodeByURL("https://www.baidu.com/s?ie=UTF-8&wd=风景");
        System.out.println("url = " + url);

    }
}
