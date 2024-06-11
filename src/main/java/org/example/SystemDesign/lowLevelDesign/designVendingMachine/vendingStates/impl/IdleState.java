package org.example.SystemDesign.lowLevelDesign.designVendingMachine.vendingStates.impl;

import org.example.SystemDesign.lowLevelDesign.designVendingMachine.Coin;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.Item;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.VendingMachine;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.vendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(){
        System.out.println("Currently vending machine is in idle state!!");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently vending machine is in idle state!!");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("First you need to click on insert coin button.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You can not insert coin in idle state.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You can not choose product in idle state.");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in idle state.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product can not be dispensed in idle state.");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("You can not get refund in idle state.");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
}
