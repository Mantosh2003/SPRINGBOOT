package com.jt;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private String course[];
    // right click>source action>generate constructor (shortcut)
    public Student(int id, String name, String[] course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Student() {
    }

    @Override
    public String toString() {    
        return "Student [id=" + id + ", name=" + name + ", course=" + Arrays.toString(course) + "]";
    }

    public int getId() {
        System.out.println("####################");
        return id;
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("$$$$$$$$$$$$$");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }
    
    
}
