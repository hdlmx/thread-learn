package cn.hdlmx.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 初试
 */
public class CASTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5, 2019);
        //把atomicInteger设置为2018时没生效
        atomicInteger.compareAndSet(5, 2018);
        System.out.println(atomicInteger.get());
        //期望值为2019时，再设置为2018时成功
        atomicInteger.compareAndSet(2019, 2018);
        System.out.println(atomicInteger.get());

    }
}
