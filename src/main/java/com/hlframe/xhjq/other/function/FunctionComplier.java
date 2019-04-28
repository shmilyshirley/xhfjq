package com.hlframe.xhjq.other.function;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-24 20:08
 */
public class FunctionComplier {
    public static void main(String[] args) {
        /**
         * 面向对象方法
         */
        RunableImpl runable1 = new RunableImpl();
        Thread thread1 = new Thread(runable1);
        thread1.start();

        /**
         * 内部类方法
         */
        Runnable runable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println( "内部类线程名：" + Thread.currentThread().getName() );
            }
        };
        Thread thread = new Thread(runable2);
        thread.start();

        /**
         * 匿名内部类方法
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( "匿名内部类线程名：" + Thread.currentThread().getName() );
            }
        }).start();
    }
}
