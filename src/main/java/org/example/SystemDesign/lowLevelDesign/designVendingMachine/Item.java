package org.example.SystemDesign.lowLevelDesign.designVendingMachine;

public class Item {
    ItemType itemType;
    int price;

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
