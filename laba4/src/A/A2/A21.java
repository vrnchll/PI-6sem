package A.A2;

public class A21 {
    public int param;

    public A21(int parameter)
    {
        this.param = parameter;
    }

    public void printInfo()
    {
        System.out.println(this.getClass() +" - "+ this.param);
    }
}
