package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Model of airplane: " + this.name);
    }

    public void printCountEngine() {
        if ("A380".equals(this.name)) {
            System.out.println("Count of engine: 4");
        } else {
            System.out.println("Count of engine: " + COUNT_ENGINE);
        }
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
