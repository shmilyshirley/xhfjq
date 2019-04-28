package com.hlframe.xhjq.other.function;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-24 20:42
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        /**
         * 匿名内部类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( "匿名内部类：" + Thread.currentThread().getName() );
            }
        }).start();

        /**
         * Lambda表达式
         */
        new Thread( () -> {
            System.out.println( "Lambda表达式：" + Thread.currentThread().getName() );
        }).start();
    }
}
