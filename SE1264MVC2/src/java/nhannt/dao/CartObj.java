/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Trung Nhan
 */
public class CartObj implements Serializable{
    private Map<String, Integer> items;
    private String customerID;

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    public String getCustomerID() {
        return customerID;
    }
    
    public void addItemToCart(String title){
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        
        int quantity = 1;
        if (this.items.containsKey(title)) {
            quantity = this.items.get(title) + 1;
        }
        
        this.items.put(title, quantity);
    }
    
    public void removeItemFromCart(String title){
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(title)) {
            this.items.remove(title);
            if (this.items.isEmpty()) {
                return;
            }
        }
    }
}
