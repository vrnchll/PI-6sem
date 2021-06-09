package A.A2;

public class A22 {
    public int param;

    public A22(int parameter)
    {
        this.param = parameter;
    }

    public void printInfo()
    {
        System.out.println(this.getClass() +" - "+ this.param);
    }
}
