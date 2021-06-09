package A.A2.B.B2;

public class B21 {
    public int param;

    public B21(int parameter)
    {
        this.param = parameter;
    }

    public void printInfo()
    {
        System.out.println(this.getClass() +" - "+ this.param);
    }
}
