import Exception.*;

public class AAA {

    AAA(Integer i) throws ExceptionAAA1
    {
        if(i==null) throw new ExceptionAAA1();
    }
    public void methode(int a) throws ExceptionAAA2, ExceptionAAA3
    {
        if (a == 0) throw new ExceptionAAA2();
        else if (a<0) throw new ExceptionAAA3();
    }

}
