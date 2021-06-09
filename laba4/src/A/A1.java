package A;

public class A1 {
    public int param;

    public A1(int parameter)
    {
        this.param = parameter;
    }

    public void printInfo()
    {
        System.out.println(this.getClass() +" - "+ this.param);
    }
}
