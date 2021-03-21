package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Driving!");
    }

    @Override
    public void passengers(int countPerson) {
        System.out.println("Count person: " + countPerson);
    }

    @Override
    public int price(int volumeGaz) {
        int cost = 45;
        return volumeGaz * cost;
    }
}
