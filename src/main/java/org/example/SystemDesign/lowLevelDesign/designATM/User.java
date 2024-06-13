package org.example.SystemDesign.lowLevelDesign.designATM;

public class User {

    Card card;
    UserBankAccount bankAccount;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
