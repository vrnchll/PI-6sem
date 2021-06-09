import A.A2.A3.A4.*;//2
import A.*; //3

import A.A2.B.B2.B3.B4.*;
import A.A2.B.*;

public class Main {

    public static void main(String[] args) {

        //1
        A1 a1 = new A1(12);
        a1.printInfo();

        A.A2.A21 a21 = new A.A2.A21(13);
        a21.printInfo();
        A.A2.A22 a22 = new A.A2.A22(14);
        a22.printInfo();

        A.A2.A3.A31 a31 = new A.A2.A3.A31(15);
        a31.printInfo();
        A.A2.A3.A32 a32 = new A.A2.A3.A32(16);
        a32.printInfo();

        A.A2.A3.A4.A41 a41 = new A.A2.A3.A4.A41(17);
        a41.printInfo();
        A.A2.A3.A4.A42 a42 = new A.A2.A3.A4.A42(18);
        a42.printInfo();

        //2
        A41 a411 = new A41(222);
        a411.printInfo();
        A42 a421 = new A42(223);
        a421.printInfo();

        //3
        A1 a11 = new A1(44);
        a11.printInfo();



        //А.А2.B
        //5
        A.A2.B.B1 b1 = new A.A2.B.B1(100);
        b1.printInfo();

        A.A2.B.B2.B21 b21 = new A.A2.B.B2.B21(101);
        b21.printInfo();
        A.A2.B.B2.B22 b22 = new A.A2.B.B2.B22(102);
        b22.printInfo();

        A.A2.B.B2.B3.B31 b31 = new A.A2.B.B2.B3.B31(103);
        b31.printInfo();
        A.A2.B.B2.B3.B32 b32 = new A.A2.B.B2.B3.B32(104);
        b32.printInfo();

        A.A2.B.B2.B3.B4.B41 b41 = new A.A2.B.B2.B3.B4.B41(105);
        b41.printInfo();
        A.A2.B.B2.B3.B4.B42 b42 = new A.A2.B.B2.B3.B4.B42(106);
        b42.printInfo();


        B41 b411 = new B41(1000);
        b411.printInfo();
        B42 b421 = new B42(1001);
        b421.printInfo();


        B1 b11 = new B1(1002);
        b11.printInfo();


        //6
        UsingA info = new UsingA();
        info.GetInfo();

        //7
        SuperB b = new SuperB(5555);
        b.printInfo();
    }
}
