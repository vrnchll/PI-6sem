package com.company;

public class DDD extends CCC{
    public int x;
    private int y;

    public  DDD()
    {
        super();
        this.x=1;
        this.y=1;
    }

    public  DDD(int x,int y)
    {
        super(x,y);
    }
    public int sum()
    {
        int resCCC = super.sum();
        return resCCC + x + y;
    }
    public int calc()
    {
        int resCCC = super.sum();
        return (x+y)*resCCC;
    }
}
