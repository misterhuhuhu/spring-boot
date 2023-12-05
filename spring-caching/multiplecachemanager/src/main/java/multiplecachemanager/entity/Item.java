package multiplecachemanager.entity;

import java.util.ArrayList;
import java.util.List;

public class Item {
    
    private int itemId;
    
    private String itemDesc;
    
    private double itemPrice;
    
    public int getItemId() {
        return itemId;
    }
    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    public String getItemDesc() {
        return itemDesc;
    }
    
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    
    public double getItemPrice() {
        return itemPrice;
    }
    
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public Item() {
    }
    
    public Item(int itemId, String itemDesc, double itemPrice) {
        this.itemId = itemId;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
    }
    
    public static List<Item> getItem() {
        return new ArrayList<>(){{
            add(new Item(1001,"ITEM1",50.0));
            add(new Item(1002,"ITEM2",100.0));
        }};
    }
}
