package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student person1 = new Student();
        person1.setName("Ivanov Ivan Ivanovich");
        person1.setGroup("1233441");
        person1.setCredited(new Date());
        System.out.println( "Student: " + person1.getName() + System.lineSeparator() +
                            "Group No: " + person1.getGroup() + System.lineSeparator() +
                            "Date of credited: " + person1.getCredited() + System.lineSeparator());
    }
}
