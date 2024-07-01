package com.xenostar;

import java.util.Scanner;

public class Thread2 extends  Thread{
    int j=1;
    int corIndex;

    @Override
    public  void  run(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select Course:");
        for(Course cor:Course.getCL()){
            System.out.println(j+" "+cor.getCname());
            j++;
        }
        System.out.print("-->");
        corIndex = input.nextInt();
    }

    public int getCorIndex(){
        return  corIndex;
    }


}
