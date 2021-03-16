package ru.jobj4.oop;

public class Student {
    public void music() {
        System.out.println("Tra Tra-ta Ta-ta-ta");
    }

    public void song() {
        System.out.println("Du...duhast...duhastmish");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
