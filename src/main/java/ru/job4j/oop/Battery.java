package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery capacity1 = new Battery(10);
        Battery capacity2 = new Battery(2);
        System.out.println("Capacity battery 1 is " + capacity1.load);
        System.out.println("Capacity battery 2 is " + capacity2.load);
        capacity1.exchange(capacity2);
        System.out.println("Capacity battery 1 is " + capacity1.load);
        System.out.println("Capacity battery 2 is " + capacity2.load);
    }
}
