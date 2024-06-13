package org.example.SystemDesign.lowLevelDesign.designATM.ATMStates;


import org.example.SystemDesign.lowLevelDesign.designATM.ATM;
import org.example.SystemDesign.lowLevelDesign.designATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
