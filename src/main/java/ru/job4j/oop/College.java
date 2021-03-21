package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman personF = new Freshman();
        Student personS = personF;
        Object obj = personF;
    }
}
