package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных для хранения информации о клиентах банка
 * @author VLADIMIR KUTYAVIN
 * @version 1.0
 */
public class User {
    /**
     * Информация хранится в строковых полях
     */
    private String passport;
    private String username;

    /**
     * Конструктор для создания экземпляров класса. Принмает два параметра
     * @param passport номер паспорта клиента
     * @param username имя клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для получения доступа к полю экземпляра,
     * текущего класса - passport
     * @return возвращает номер паспорта клиента, в строковом формате
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для записи информации о номере паспорта клиента
     * @param passport принимает на вход номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для получения доступа к полю экземпляра,
     * текущего класса - username
     * @return возвращает имя клиента, в строковом формате
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для записи информации имени клиента
     * @param username принимает на вход имя клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
