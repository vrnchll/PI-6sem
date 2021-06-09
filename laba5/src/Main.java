import First.Second.Third.AAA;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        AAA person = new AAA();

        person.setName("Veronika");
        person.setFatherName("Sergeevna");
        person.setSurname("Bobrik");
        person.setBirthday(100,9,20);//100 тк считает от 1900
        person.setUniversity("BSTU");
        person.setFirstDate(new Date(118,8,01));

        System.out.println("Info about person:");
        System.out.println("Name: "+person.getName());
        System.out.println("Fathername: "+person.getFatherName());
        System.out.println("Surname: "+person.getSurname());
        System.out.println("Birthday: "+person.getBirhtday());
        System.out.println("University: "+person.getUniversity());
        System.out.println("FirstDate: "+person.getFirstDate());
    }
}
