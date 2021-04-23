package jspclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Regimex {

    protected String R = null;
    protected Calendar c;
    protected Date d  = new Date();
    protected SimpleDateFormat simpledateformat = new SimpleDateFormat("dd.MM.yyyy");
    public Regimex(Calendar c) {
        this.c = c;
    }

    public Regimex() {
        this.c = Calendar.getInstance();
    }
    public Integer GetDayOfWeek() {
        Integer var1 = this.c.get(7) - 1;
        return var1 == 0 ? 7 : this.c.get(7) - 1;
    }
    public Integer GetHour() {
        return (Integer) c.get(Calendar.HOUR_OF_DAY);
    }
    public String GetCurrentDate() {
        return this.simpledateformat.format(this.c.getTime());
    }
    public String AddDays(Integer var1) {
        this.c.add(6, var1);
        return this.simpledateformat.format(this.c.getTime());
    }

}