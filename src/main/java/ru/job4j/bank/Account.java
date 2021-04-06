package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных для хранения информации о
 * банковских счетах клиентов
 * @author VLADIMIR KUTYAVIN
 * @version 1.0
 */
public class Account {
    /**
     * Основные поля для хранения данных: реквизиты типа String
     * и баланс - типа double
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор экземпляров класса. Принимает на вход два параметра:
     * реквизиты и размер баланса
     * @param requisite реквизиты счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает реквизиты, вызывающего объекта
     * @return реквизиты в формате строки
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод, позволяет установить реквизиты, вызывающего объекта
     * @param requisite принимает на вход реквизиты в строковом формате
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод, позволяет получить информацию о балансе, вызывающего объекта
     * @return возвращает баланс счета в числовом виде
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод, позволяет установить значение в поле баланса
     * @param balance принимает в качестве параметра значение баланса
     * в числовом формате
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
