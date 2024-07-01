package com.xenostar;

import java.util.ArrayList;

public class Student {
    private  int sId;
    private  String sname;
    private  static ArrayList<Student> SL = new ArrayList<>();
    private  ArrayList<Course> sCourses = new ArrayList<>();



    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public  ArrayList<Course> getsCourses(){
        return sCourses;
    }

    public static ArrayList<Student> getSL(){
        return SL;
    }

    public void addToList(){
        SL.add(this);
    }

    public void addCourse(Course course){
        sCourses.add(course);
    }

}
