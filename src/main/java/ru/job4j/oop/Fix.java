package ru.job4j.oop;

public class Fix {
    private final String desc;

    public Fix(String text) {
        this.desc = text;
    }

    public static void main(String[] args) {
        Fix instance1 = new Fix("some description first object");
        System.out.println(instance1.desc);
        Fix instance2 = new Fix("some description second object");
        System.out.println(instance2.desc);
    }
}
