package ru.job4j.pojo;

public class Book {
    private final String title;
    private final int amountPage;

    public Book(String title, int amountPage) {
        this.title = title;
        this.amountPage = amountPage;
    }

    public String getTitle() {
        return title;
    }

    public int getAmountPage() {
        return amountPage;
    }
}
