package com.example.student_servlet_jdbc.week12.model;

public class Student {
    protected int id;
    protected String name;
    protected String sex;
    protected String address;

    public Student() {
    }

    public Student(String name, String sex, String address) {
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public Student(int id, String name, String sex, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
