package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public String nameVehicle() {
        return "Airplane";
    }

    @Override
    public void move() {
        System.out.println("Airplane is flying in sky");
    }

    @Override
    public int passengerCapacity() {
        return 400;
    }

    @Override
    public int maxSpeed() {
        return 950;
    }
}
