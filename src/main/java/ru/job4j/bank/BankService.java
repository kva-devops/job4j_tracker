package ru.job4j.bank;

import java.util.*;

/**
 * Класс реализует работу банковского сервиса, который позволяет
 * производить различные банковские операции
 * @author VLADIMIR KUTYAVIN
 * @version 1.0
 */
public class BankService {
    /**
     * База клиентов хранится в коллекции типа HashMap
     * ключом выступает объект класса User,
     * значением - объект класса Account
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет в базу нового клиента
     * @param user принимает в качестве параметра объект класса User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет клиенту новый счет
     * @param passport принмает номер паспорта клиента в строковом формате
     * @param account принимает объект класса Account, в качестве
     * нового, добавляемого счета
     */
    public void addAccount(String passport, Account account) {
        Optional<User> rslUser = findByPassport(passport);
        if (rslUser.isPresent()) {
            List<Account> rsl = users.get(rslUser.get());
            if (!rsl.contains(account)) {
                rsl.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск КЛИЕНТА по номеру паспора
     * @param passport принимает номер паспорта в строковом формате
     * @return возвращает объект типа User, если клиент найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск СЧЕТА КЛИЕНТА по номеру паспорта
     * и реквизитам счета
     * @param passport принимает номер паспорта клиента в строковой форме
     * @param requisite принимает реквизиты искомого счета
     * @return возвращает найденный счет в виде объекта типа Account
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> rslUser = findByPassport(passport);
        if (rslUser.isPresent()) {
            return users.get(rslUser.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод осуществляет операцию перевода средств с одного счета
     * на другой
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма для перевода
     * @return возвращает статус произведенной операции:  true/false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
