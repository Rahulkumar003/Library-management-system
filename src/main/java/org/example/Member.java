package org.example;

import java.security.PrivateKey;

public class Member
{
    private String name;
    private int age;
    private String phoneNumber;
    private int fines;
    private int MemberId=1000;
    private Books issue1=null;
    private Books issue2=null;
    Member(String name,int age,String phoneNumber){
        this.name=name;
        this.age=age;
        this.phoneNumber=phoneNumber;
        this.fines=0;
        this.MemberId+=1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getFines() {
        return fines;
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFines(int fines) {
        this.fines = fines;
    }

    public void setMemberId(int memberId) {
        this.MemberId = memberId;
    }

    public void setIssue1(Books book1) {
        this.issue1 = book1;
    }

    public void setIssue2(Books book2) {
        this.issue2 = book2;
    }

    public Books getIssue1() {
        return issue1;
    }

    public Books getIssue2() {
        return issue2;
    }
}

