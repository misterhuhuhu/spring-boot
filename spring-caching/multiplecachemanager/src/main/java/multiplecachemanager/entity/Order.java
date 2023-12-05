package multiplecachemanager.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;

    private int itemId;

    private int quantity;

    private int customerId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public Order() {
    }
    
    public Order(int orderId, int itemId, int quantity, int customerId) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.customerId = customerId;
    }
    public static List<Order> getOrder(){
        return new ArrayList<>(){{
            add(new Order(30001,1001,10001,1001));
            add(new Order(30002,1001,10002,5));
        }};
    }
}
