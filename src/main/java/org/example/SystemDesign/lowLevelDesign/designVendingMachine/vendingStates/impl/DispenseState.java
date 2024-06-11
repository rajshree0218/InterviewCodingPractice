package org.example.SystemDesign.lowLevelDesign.designVendingMachine.vendingStates.impl;

import org.example.SystemDesign.lowLevelDesign.designVendingMachine.Coin;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.Item;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.VendingMachine;
import org.example.SystemDesign.lowLevelDesign.designVendingMachine.vendingStates.State;

import java.util.List;

public class DispenseState implements State {

    DispenseState(VendingMachine vendingMachine, int codeNumber) throws Exception{
        System.out.println("Currently vending machine is in Dispense State!!");
        dispenseProduct(vendingMachine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("insert coin button can not clicked on Dispense state.");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Product selection button can not be clicked in Dispense State.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You can not insert coin in dispense state.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You can not choose product in dispense state.");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in dispense state.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed.");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("You can not get refund in dispense state.");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in dispense state");
    }
}
