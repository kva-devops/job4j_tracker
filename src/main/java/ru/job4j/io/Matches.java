package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Game 11");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Player 1" : "Player 2";
            System.out.println(player + " enter num from 1 to 3");
            int matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= 3) {
                turn = !turn;
                count -= matches;
            } else {
                System.out.println("Non correct num. Try again.");
            }
            System.out.println("Matches on table: " + count);
        }
        if (!turn) {
            System.out.println("Player 1 win");
        } else {
            System.out.println("Player 2 win");
        }
    }
}
