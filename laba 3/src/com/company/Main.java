package com.company;

public class Main {

    public static void main(String[] args) {

        CCC c = new CCC();
        CCC с1 = new CCC(7,4);

        System.out.println(с1.sum());
        System.out.println(c.ssub(8,5));

        DDD d = new DDD();
        DDD d1 = new DDD(12,6);

        System.out.println(d1.sum());
        System.out.println(d1.calc());
    }
}
