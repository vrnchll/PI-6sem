package com.company;

public class Main {

    public static void main(String[] args) {
        int num_1=6;
        int num_2=5;

        float num_3=1.8f;
        float num_4=1.7f;

        double num_5,num_6;
        num_5=2.2;
        num_6=1.3;

        //1
        Expression_1(num_1,num_2);
        //2
        Expression_2(num_3,num_4);
        //3
        Expression_3(num_5,num_6);

        //z2
        char a='a';
        char b='b';

        System.out.print("a+b = ");//1
        System.out.println(a+b);

        System.out.print("a-b = ");//2
        System.out.print(a-b);
    }

    public static void Expression_1 (int a1, int b1) {
        int result;
        result = (int)Math.pow(a1,2) - (int)Math.pow(b1,2); //int потому что функция pow имеет аргументы double
        System.out.println("The result of Expression_1 is: "+result);
    }

    public static void Expression_2 (float a2, float b2) {
        float result;
        result = (float) Math.pow(a2,3) - (float) Math.pow(b2,3);
        System.out.println("The result of Expression_2 is: "+result);
    }

    public static void Expression_3 (double a2, double b2) {
        double result;
        result = Math.pow(a2,4) - Math.pow(b2,4); 
        System.out.println("The result of Expression_2 is: "+result);
    }
}
