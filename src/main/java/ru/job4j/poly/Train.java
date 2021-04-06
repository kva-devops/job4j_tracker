package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public String nameVehicle() {
        return "Train";
    }

    @Override
    public void move() {
        System.out.println("Train is running on railway");
    }

    @Override
    public int passengerCapacity() {
        return 500;
    }

    @Override
    public int maxSpeed() {
        return 100;
    }
}
