package ru.job4j.builder;

public class PersonalComputer  {
    private String motherBoard;
    private String processor;
    private String memory;
    private String power;
    private int price;

    static class Builder {
        private String motherBoard;
        private String processor;
        private String memory;
        private String power;
        private int price;

        Builder buildMotherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }

        Builder buildProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        Builder buildMemory(String memory) {
            this.memory = memory;
            return this;
        }

        Builder buildPower(String power) {
            this.power = power;
            return this;
        }

        Builder buildPrice(int price) {
            this.price = price;
            return this;
        }

        PersonalComputer build() {
            PersonalComputer pc = new PersonalComputer();
            pc.motherBoard = motherBoard;
            pc.processor = processor;
            pc.memory = memory;
            pc.power = power;
            pc.price = price;
            return pc;
        }
    }

    @Override
    public String toString() {
        return "PersonalComputer{"
                + "motherBoard='" + motherBoard + '\''
                + ", processor='" + processor + '\''
                + ", memory='" + memory + '\''
                + ", power='" + power + '\''
                + ", price=" + price
                + '}';
    }

    public static void main(String[] args) {
        PersonalComputer somePc = new Builder()
                .buildMotherBoard("Asus")
                .buildProcessor("Intel")
                .buildMemory("Kingston")
                .buildPower("FSP")
                .buildPrice(200)
                .build();
        System.out.println(somePc);
    }
}
