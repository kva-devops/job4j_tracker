package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book item1 = new Book("Clean code", 435);
        Book item2 = new Book("Effective Java", 500);
        Book item3 = new Book("Network Programming", 1000);
        Book item4 = new Book("Tannenbaum", 2000);
        Book[] shelf = new Book[4];
        shelf[0] = item1;
        shelf[1] = item2;
        shelf[2] = item3;
        shelf[3] = item4;
        for (int i = 0; i < shelf.length; i++) {
            System.out.println(
                            "Book's index: " + i + ", " +
                            "Book's title: " + "\"" + shelf[i].getTitle() + "\"" + ", " +
                            "Amount of page: " + shelf[i].getAmountPage());
        }
        Book temp = shelf[0];
        shelf[0] = shelf[3];
        shelf[3] = temp;
        System.out.println();
        for (int i = 0; i < shelf.length; i++) {
            System.out.println(
                            "Book's index: " + i + ", " +
                            "Book's title: " + "\"" + shelf[i].getTitle() + "\"" + ", " +
                            "Amount of page: " + shelf[i].getAmountPage());
        }
        System.out.println();
        for (int i = 0; i < shelf.length; i++) {
            if (shelf[i].getTitle().equals("Clean code")) {
                    System.out.println(
                            "Book's index: " + i + ", " +
                            "Book's title: " + "\"" + shelf[i].getTitle() + "\"" + ", " +
                            "Amount of page: " + shelf[i].getAmountPage());
            }
        }
    }
}
