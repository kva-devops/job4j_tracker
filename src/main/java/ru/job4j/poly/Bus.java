package ru.job4j.poly;

public class Bus implements Vehicle {
    @Override
    public String nameVehicle() {
        return "Bus";
    }

    @Override
    public void move() {
        System.out.println("Bus goes on the road");
    }

    @Override
    public int passengerCapacity() {
        return 40;
    }

    @Override
    public int maxSpeed() {
        return 140;
    }
}
