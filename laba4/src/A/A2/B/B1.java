package A.A2.B;

public class B1 {
    public int param;

    public B1(int parameter)
    {
        this.param = parameter;
    }

    public void printInfo()
    {
        System.out.println(this.getClass() +" - "+ this.param);
    }
}
