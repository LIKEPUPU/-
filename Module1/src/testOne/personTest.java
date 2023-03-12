package testOne;

import java.util.Scanner;

public class personTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        person p = new person();
        p.setName("小明");
        p.setAge(sc.nextInt());
        p.setGender("男");

        System.out.println(p.getName());
        System.out.println(p.getGender());
        System.out.println(p.getAge());
    }

}
