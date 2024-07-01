package com.xenostar;



import java.util.Scanner;

public class Thread1 extends  Thread{
    int i=1;
    int stuIndex;

    @Override
    public  void  run(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select Student:");
        for(Student stu:Student.getSL()){
            System.out.println(i+" "+stu.getSname());
            i++;
        }
        System.out.print("-->");
        stuIndex = input.nextInt();
    }

    public int getStuIndex(){
        return  stuIndex;
    }


}
