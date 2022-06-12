package cn.hdlmx.final_;

import java.util.Random;

public class FinalTest {
    static Random r = new Random();
    final int ss;
    final int k = r.nextInt(10);
    static final int k2 = r.nextInt(10);
    FinalTest(int ss){
        this.ss=ss;
    }

    public static void main(String[] args) {

        final FinalTest t1 = new FinalTest();
        System.out.println("k=" + t1.k + " k2=" + t1.k2);
        FinalTest t2 = new FinalTest();
        System.out.println("k=" + t2.k + " k2=" + t2.k2);
    }
}
