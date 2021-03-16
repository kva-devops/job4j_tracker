package ru.job4j.oop;

public class Cat {
    private String food;
    private String nick;

    public void show() {
        System.out.println(this.nick);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.nick = nick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("meatballs");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        System.out.println("This is nick and meat first cat: ");
        gav.show();
        System.out.println("This is nick and meat second cat: ");
        black.show();
    }
}
