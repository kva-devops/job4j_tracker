package ru.job4j.bank;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;

public class BankServiceTest {

    @Test
    public void testAddUser() {
        User user = new User("2222", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Assert.assertThat(bank.findByPassport("2222"), is(user));
    }

    @Test
    public void testAddAccount() {
        User user = new User("2222", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("2111", 200D));
        Assert.assertThat(bank.findByRequisite("2222", "2111").getBalance(), is(200D));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("2222", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("2111", 200D));
        Assert.assertThat(bank.findByRequisite("3333", "2111"), is(nullValue()));
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
        Assert.assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(),
                is(200D));

    }
}