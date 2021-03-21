package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.println("Я великий оракул. Что ты хочешь узнать?");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0 -> System.out.println("Yes");
            case 1 -> System.out.println("No");
            default -> System.out.println("Maybe");
        }
    }
}
