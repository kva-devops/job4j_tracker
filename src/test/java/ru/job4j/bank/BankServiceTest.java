package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;

public class BankServiceTest {

    @Test
    public void testAddUser() {
        User user = new User("2222", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Assert.assertThat(bank.findByPassport("2222").get(), is(user));
    }

    @Test
    public void testAddAccount() {
        User user = new User("2222", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("2111", 200D));
        Assert.assertThat(bank.findByRequisite("2222", "2111").get().getBalance(),
                is(200D));
    }

    @Test
    public void testAddAccountReply() {
        User user = new User("2222", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("1111", 200D));
        bank.addAccount(user.getPassport(), new Account("1111", 100D));
        Assert.assertThat(bank.findByRequisite("2222", "1111").get(),
                is(new Account("1111", 200D)));
    }

    @Test
    public void testInvalidAccount() {
        User user = new User("2222", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("2111", 200D));
        Assert.assertThat(bank.findByRequisite("2222", "1111"), is(Optional.empty()));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("2222", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("2111", 200D));
        Assert.assertThat(bank.findByRequisite("3333", "2111"), is(Optional.empty()));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546",
                            user.getPassport(), "113",
                        150D);
        Assert.assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(),
                is(200D));

    }

    @Test
    public void transferMoneyInvalid() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Assert.assertThat(bank.transferMoney(user.getPassport(), "5546",
                                             user.getPassport(), "113",
                                            150D),
                                                is(false));
    }

}