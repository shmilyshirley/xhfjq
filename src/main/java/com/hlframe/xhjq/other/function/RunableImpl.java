package com.hlframe.xhjq.other.function;

/**
 * @company:华量软件
 * @author:Fan Junhan
 * @email:fjh@hleast.com
 * @date:2019-04-24 20:08
 */
public class RunableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println( "线程名：" +Thread.currentThread().getName() );
    }
}
