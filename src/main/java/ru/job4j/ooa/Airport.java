package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        System.out.println("<<< Create airplanes >>>");
        final Airbus airbus1 = new Airbus("A320");
        System.out.println(airbus1);
        airbus1.printModel();
        airbus1.printCountEngine();
        System.out.println("======================");
        final Airbus airbus2 = new Airbus("A380");
        System.out.println(airbus2);
        airbus2.printModel();
        airbus2.printCountEngine();
        System.out.println("======================");
        System.out.println("<<< Modify first airplane >>>");
        airbus1.setName("A380");
        System.out.println(airbus1);
        airbus1.printModel();
        airbus1.printCountEngine();
    }
}
