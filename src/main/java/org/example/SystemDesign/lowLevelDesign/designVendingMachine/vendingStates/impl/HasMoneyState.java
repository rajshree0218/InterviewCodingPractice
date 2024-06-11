package org.example.SystemDesign.lowLevelDesign.designVendingMachine.vendingStates.impl;

import org.example.SystemDesign.lowLevelDesign.designVendingMachine.Coin;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.Item;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.VendingMachine;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.vendingStates.State;

import java.util.List;

public class HasMoneyState implements State {
    public HasMoneyState(){
        System.out.println("Currently vending machine is in HasMoneyState!!");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        return ;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
       machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin!!");
        machine.getCoinList().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You need to click on start product selection button first.");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in has money state.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product can not be dispensed in has money state.");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the coin dispense tray!!");
        machine.setVendingMachineState(new IdleState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("You can not update item in has money state.");
    }
}
