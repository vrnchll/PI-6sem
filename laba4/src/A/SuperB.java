package A;

import A.A2.B.B2.B21;

public class SuperB extends B21 {

    public SuperB(int parameter) {
        super(parameter);
    }
    public void printInfo()
    {
        System.out.println(this.getClass() +" - "+ this.param + " this is super class");
    }

}

