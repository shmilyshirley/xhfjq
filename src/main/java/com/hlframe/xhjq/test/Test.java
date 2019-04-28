package com.hlframe.xhjq.test;

import com.hlframe.xhjq.utils.EncodeUtils;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-02-05 14:31
 */
public class Test {
    public static void main(String[] args) {
        String s = EncodeUtils.EncodeByBase64("ss://cmM0LW1kNTpoZWNodW55YW4xMzE0NTIwQDM1LjIzNi4xNTcuMjM0OjEzMTQ#Mac%20iOS%E9%80%9A%E7%94%A8%20%E5%8F%B0");
        System.out.println("s = " + s);
    }
}
