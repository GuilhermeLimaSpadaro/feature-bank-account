package model.entities;

import model.exceptions.DomainExceptions;

public class Account {

    Integer number;
    String holder;
    Double balance;
    Double withDrawLimit;

    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(Double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withDraw(Double amount) throws DomainExceptions {
        validateWithdraw(amount);
        this.balance -= amount;
    }

    private void validateWithdraw(Double amount) throws DomainExceptions {
        if (amount > getWithDrawLimit()){
            throw new DomainExceptions("Withdraw error: The amount exceeds the maximum allowed limit");
        }
        if (amount > getBalance()) {
            throw new DomainExceptions("Withdrawn error: Not enough balance");
        }
    }
}
