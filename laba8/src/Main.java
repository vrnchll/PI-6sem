public class Main {
    //11 простые перечисления
    /*public  enum  Main.Planet
    {
        MERCURY,
        VENUS,
        EARTH,
        MARS,
        JUPITER,
        SATURN,
        URANUS,
        NEPTUN;
    }*/
    //12
    public enum  Planet
    {
        MERCURY(3.302e+23, 2.439e+06),
        VENUS(3.202e+23, 2.339e+06),
        EARTH(3.102e+23, 2.239e+06),
        MARS(3.720e+24, 2.139+06),
        JUPITER(3.620e+24, 2.125e+06),
        SATURN(3.345e+25, 2.222e+06),
        URANUS(2.302e+26, 2.405e+07),
        NEPTUN(1.024e+26, 2.477e+07);
        private final double mass;
        private final double radius;
        private  final double gravity;
        private static final  double G = 6.673000e-11;
        Planet(double mass, double radius)
        {
            this.mass = mass;
            this.radius = radius;
            this.gravity = G*mass/(radius*radius);
        }
    }
    //5 собственное расширенное перечисление
    public enum Subjects {
        Math(2,"Mon"),
        Phy(4,"Wedn"),
        Che(1,"Fri"),
        Bio(2,"Tue");
        private final int hours;
        private  final String day;
        Subjects(int hours, String day)
        {
            this.day = day;
            this.hours = hours;
        }
    }



    public static void main(String[] args) {
	//1
        //2
        System.out.println("Task 2");
        String s01 = new String();
        System.out.println("s01.length = "+ s01.length());
        char[] cs = {'0','1','2','3','4','5','6','7'};
        String s02 = new String(cs);
        System.out.println("s02.length = "+ s02.length() + "s02 = " + s02);
        String s03 = new String(cs,3,5);
        System.out.println("s03.length = "+ s03.length() + "s03 = " + s03);
        String s04 = ("01234567");
        System.out.println("s04.length = "+ s04.length() + "s04 = " + s04);
        String s05 = new String("01234567");
        System.out.println("s05.length = "+ s05.length() + "s05 = " + s05);
        //3
        System.out.println("Task 3");
        System.out.println("\"01234567\".length = " + "01234567".length());
        //4 извлечение символов
        System.out.println("Task 4");
        String s06 = new String("01234567");
        for(int i=0; i<s06.length(); i++){
            System.out.print(s06.charAt(i)+(i<s06.length() - 1 ? "-" : ""));
        }
        System.out.println("");
        char[] cs1 = new char[6-2];
        s06.getChars(2,6,cs1,0);//копирует символы из данной строки в массив символов назначения
        for(int i=0;i<cs1.length;i++)
        {
            System.out.print(cs1[i]+((i<cs1.length - 1)? "-" : ""));
        }
        //5 сравнение строк
        System.out.println("Task 5");
        String s07 = new String("01234567");
        String s08 = new String("01234567");
        System.out.println( "(s07 == s08) = " + (s07 == s08));
        System.out.println( "(s07 == \"01234567\") = " + (s07 == "01234567"));
        System.out.println( "s07.equals(s08)" + s07.equals(s08));
        String s09 = s08;
        System.out.println( "(s08 == s09) = " + (s08 == s09));
        //6 поиск символа или подстроки
        System.out.println("Task 6");
        String s10 = new String("Человека невозможно чему-нибудь научить, его можно убедить");
        System.out.println(s10.indexOf('j'));
        System.out.println(s10.indexOf('о'));
        System.out.println(s10.lastIndexOf('о'));
        System.out.println(s10.indexOf('о',5));
        System.out.println(s10.lastIndexOf('о',5));
        System.out.println(s10.lastIndexOf('о',14));
        //7 извлечение подстроки
        System.out.println("Task 7");
        String s11 = new String("Лучший вид на этот город, если сесть в бомбардировщик");
        System.out.println(s11.substring(26));
        System.out.println(s11.substring(26,30));
        //8 замена символов
        System.out.println("Task 8");
        String s12 = new String("Оффтопик - любое сетевое сообщение "+ "выходящее за рамки ранее установленной темы");
        System.out.println(s12.replace('ф','f'));
        System.out.println(s12.toUpperCase());
        System.out.println(s12.toLowerCase());
        //9
        System.out.println("Task 9");
        StringBuffer s15 = new StringBuffer(100);
        s15.append("В город Сочи темные ночи");//обновляет значение объекта
        System.out.println("s15.length()  = "+s15.length());
        System.out.println("s15.capacity()  = "+s15.capacity());
        s15.insert(21, "и теплые ");
        System.out.println(s15);
        System.out.println("s15.length()  = "+s15.length());
        System.out.println("s15.capacity()  = "+s15.capacity()); //получить количество символов, для которых зарезервирована память
        s15.delete(21,30);
        System.out.println(s15);
        s15.ensureCapacity(200);//изменяется минимальная емкость буфера символов
        System.out.println("s15.capacity()  = "+s15.capacity());
        String s16 = s15.toString();
        //11
        //System.out.println("Task 11");
        /*Main.Planet planet = Main.Planet.EARTH;
        switch (planet)
        {
            case MERCURY:System.out.println("MERCURY"); break;
            case JUPITER:System.out.println("JUPITER");break;
            default: System.out.println("default");
        }*/
        //12
        System.out.println("Task 12");
        Planet planet = Planet.NEPTUN;
        System.out.println(planet.gravity);
        System.out.println(planet.mass);
        System.out.println(planet.radius);

    //5
        System.out.println("Task 5");
        Subjects subj = Subjects.Math;
        System.out.println(subj.hours);
        System.out.println(subj.day);
    }


}
