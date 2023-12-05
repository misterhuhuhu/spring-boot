package multiplecachemanager.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerId;

    private String customerName;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public Customer() {
    }
    
    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }
    public static List<Customer> getCustomer(){
        return new ArrayList<>(){{
            add(new Customer(1001,"BAELDUNG"));
        }};
    }
}
