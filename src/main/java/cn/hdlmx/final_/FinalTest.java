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

    }
}
