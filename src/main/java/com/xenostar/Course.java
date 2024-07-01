package com.xenostar;

import java.util.ArrayList;

public class Course {
    private int cId;
    private String cname;
    private int credits;

    private  static ArrayList<Course> CL = new ArrayList<>();


    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public  static ArrayList<Course> getCL(){
        return CL;
    }

    public void addToList(){
        CL.add(this);
    }


}
