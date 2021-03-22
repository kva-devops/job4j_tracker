package ru.job4j.poly;

public class UsageVehicle {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle[] listVehicle = {train, bus, airplane};

        for (Vehicle element : listVehicle ) {
            System.out.println(element.nameVehicle());
            System.out.println("Max speed: " + element.maxSpeed());
            System.out.println("Passenger capacity: " + element.passengerCapacity());
            element.move();
            System.out.println("==================================");
        }
    }
}
