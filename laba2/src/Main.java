public class Main {

    public static void main(String[] args) {
	//1
        int[] xx = new int[10];
        for(int i=0; i<xx.length; i++)
        {
            xx[i] = i;
        }
        for(int i=0; i<xx.length; i++)
        {
            System.out.println(xx[i]);
        }


        int[][] xx2 = new int[5][5];
        for (int i = 0; i<xx2.length; i++) {
                for(int j = 0; j< xx2[i].length; j++){
                        xx2[i][j] = i + j;
                }
        }
        for (int i = 0; i<xx2.length; i++) {
            System.out.println(" ");
            for(int j = 0; j< xx2[i].length; j++){
                System.out.print(xx2[i][j]);
            }
        }

        //3
        int a=22;
        int b= a>>>3;
        System.out.println("\nThe result of a>>>3 is: "+ b);
        int c= a<<=4;
        System.out.println("\nThe result of a<<=4 is: "+ c);
        int d = a^=5;
        System.out.println("\nThe result of a^=5 is: "+ d);
        int e = a&23;
        System.out.println("\nThe result of a&23 is: "+ e);
        int f = ~a;
        System.out.println("\nThe result of ~a is: "+ f);


       //4
    boolean a1 = true;
    boolean b1 = false;
    boolean c1 = a1 || b1;
    System.out.println("\nThe result of a1||b1 is: " + c1);
    boolean c2 = a1 && b1;
    System.out.println("\nThe result of a1&&b1 is: " + c2);
    boolean c3 = a1=true ? true : false;
    System.out.println("\nThe result of ?: is: " + c3);

    //5
        int num=7;
        int num_2=1;
        if(num>=7)
        {
            num++;
            System.out.println(num);
        }

        for(int i=0; i<num; i++)
        {
            System.out.print(i);
        }
        System.out.println(" ");
        while(num<15)
        {
            System.out.print(num);
            num++;
        }
        do {
            num_2+=4;
            System.out.println(num_2);
        } while(num_2<30);

        int num_3 = 1;
        int val;
        switch (num_3) {
            case 1:
                val=7;
                System.out.println("The number is "+ val);
                break;
            case 2:
                val=8;
                System.out.println("The number is "+ val);
                break;
            default:
                System.out.println("There is an another number ");
                break;
        }

        //6
        System.out.println(Number.number);
        Number.Addition(2,5);
    }
}
