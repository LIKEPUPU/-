package testTwo;

import java.util.ArrayList;
import java.util.Scanner;

public class stuManage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------学生管理系统--------------");
        System.out.println("-----------------登录界面----------------");
        System.out.println("请输入密码：");
        String passWord = "YYDS007";
        int count = 3;    //用于记录输入密码剩余机会
        for (int i = count; i >= 0; i--){
            String passWord1 = sc.next();
            if(passWord1.equals(passWord)){
                System.out.println("登录成功！");
                break;
            }else{
                count--;
                if(count == 0){
                    System.out.println("密码错误，输入次数达到上限，学生管理系统冻结，请联系管理员--020--1314520");
                    System.exit(0);
                }
                System.out.println("密码错误，你还有" + count + "次机会！");
                System.out.println("请重新输入密码：");
            }
        }
        ArrayList<stuInformation> stulist = new ArrayList<>(); //创建存放学生对象的集合
        while(true) {
            System.out.println("---------------学生管理系统--------------");
            System.out.println("1.添加功能");
            System.out.println("2.删除功能");
            System.out.println("3.修改功能");
            System.out.println("4.查询功能");
            System.out.println("5.退出");
            System.out.println("请选择您需要使用的功能：");
            int k = sc.nextInt();
            switch (k) {
                case 1 -> stuAdd(stulist);
                case 2 -> studel(stulist);
                case 3 -> stuAlter(stulist);
                case 4 -> stuInquire(stulist);
                case 5 -> System.exit(0);
            }
        }

    }
    public static ArrayList<stuInformation> stuAdd(ArrayList<stuInformation> stulist){ //添加学生信息的方法
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入学生信息：(ID  姓名  年龄  地址)");
            stuInformation stu = new stuInformation();
            stu.setId(sc.next());
            String idArr = stu.getId();
            stu.setName(sc.next());
            stu.setAge(sc.nextInt());
            stu.setAddress(sc.next());
            boolean flag = false;    //用于判断id是否存在
            for (int i = 0; i < stulist.size(); i++) {
                boolean equals = stulist.get(i).getId().equals(idArr);
                if(equals){
                    System.out.println("该学生已存在，请重新输入学生信息！");
                    flag = true;
                }
            }
            if(flag) continue;  //id重复，结束本次循环，并重新输入
            stulist.add(stu);
            System.out.println("添加成功，继续添加请按‘1’，使用其它功能请按‘2’！");
            int choice1 = sc.nextInt();
            if(choice1 == 1) {
                System.out.println("请继续输入学生信息!");
                continue;
            }
            else break;
        }
        return stulist;
    }
    public static ArrayList<stuInformation> studel(ArrayList<stuInformation> stulist){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您想删除学生的ID:");
            String idDel = sc.next();
            boolean flag = false;   //用于判断所要删除id是否存在
            for (int i = 0; i < stulist.size(); i++) {
                if (idDel.equals(stulist.get(i).getId())) {
                    stuInformation stuRemove = stulist.remove(i);  //在集合中删除该学生
                    StringBuilder arr = new StringBuilder();
                    arr.append(stuRemove.getId() + " ").append(stuRemove.getName() + " ");
                    arr.append(stuRemove.getAge() + " ").append(stuRemove.getAddress());
                    String stuDelArr = arr.toString();
                    System.out.println("已成功删除此学生：" + stuDelArr);
                    flag = true;
                }
            }
            if (!flag){
                System.out.println("该id不存在！");
                return stulist;
            }
            System.out.println("继续删除请按‘1’，使用其它功能请按‘2’！");
            int choice2 = sc.nextInt();
            if (choice2 == 1) {
                System.out.println("请继续输入学生信息!");
                continue;
            } else break;
        }
        return stulist;
    }
    public static ArrayList<stuInformation> stuAlter(ArrayList<stuInformation> stulist){
        Scanner sc = new Scanner(System.in);
        while (true){
        System.out.println("请输入您想修改学生的ID:");
        String idAlter = sc.next();
        boolean flag = false;   //用于判断所要修改id是否存在
        for (int i = 0; i < stulist.size(); i++) {
            if (idAlter.equals(stulist.get(i).getId())){
                System.out.println("请选择要修改的信息：1.id 2.姓名 3.年龄 4.地址" );
                int choice3 = sc.nextInt();
                switch (choice3){
                    case 1 -> {
                        System.out.println("请输入新的id：");
                        stulist.get(i).setId(sc.next());
                    }
                    case 2 -> {
                        System.out.println("请输入新的姓名：");
                        stulist.get(i).setName(sc.next());
                    }
                    case 3 -> {
                        System.out.println("请输入新的年龄：");
                        stulist.get(i).setAge(sc.nextInt());
                    }
                    case 4 -> {
                        System.out.println("请输入新的地址：");
                        stulist.get(i).setAddress(sc.next());
                    }
                }
            }
            flag = true;
        }
        if (!flag){
            System.out.println("该id不存在！");
            return stulist;
        }
            System.out.println("修改成功，继续修改请按‘1’，使用其它功能请按‘2’！");
            int choice4 = sc.nextInt();
            if (choice4 == 1) {
                System.out.println("请继续输入学生信息!");
                continue;
            } else break;
        }
        return  stulist;
    }
    public static void stuInquire(ArrayList<stuInformation> stulist){
        if(stulist.size() == 0){
            System.out.println("当前无学生信息，请添加后再查询！");
            return;
        }
        System.out.println("学生信息如下：");
        for (int i = 0; i < stulist.size(); i++) {
            stuInformation stu = stulist.get(i);
            System.out.println(stu.getId() + " " + stu.getName() + " "
                          + stu.getAge() + " " + stu.getAddress());
        }
    }
}
