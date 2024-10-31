package org.example;

public class BankUser {
    private String name;
    private String surname;
    private Card card;

    private int amount;


    public BankUser(String name, String surname, Card card, int amount) {
        this.name = name;
        this.surname = surname;
        this.card = card;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
