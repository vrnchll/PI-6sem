package com.company;

public class CCC {
    public int x;
    private int y;

    public CCC()
    {
        this.x=0;
        this.y=0;
    }
    public CCC(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    public int sum()
    {
        return x+y;
    }
    public static int ssub(int x, int y)
    {
        return x-y;
    }
}
