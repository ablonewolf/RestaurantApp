package com.arka99.restaurant.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Order {
    private Map<MenuItem, Integer> currentOrder = new HashMap<>();
    private String status = "order accepted";

    public void addToOrder(MenuItem menuItem, int quantity) {
        int currentQuantity = 0;
        if (currentOrder.get(menuItem) != null) currentQuantity = currentOrder.get(menuItem);
        currentOrder.put(menuItem, currentQuantity + quantity);
    }

    public Double getOrderTotal() {
        double d = 0d;
        for (MenuItem menuItem : currentOrder.keySet()) {
            d += currentOrder.get(menuItem) * menuItem.getPrice();
        }
        return d;
    }

    //added ch14
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MenuItem menuItem : currentOrder.keySet()) {
            sb.append(menuItem.getName()).append(" : ").append(currentOrder.get(menuItem)).append("<br/>");
        }
        return sb.toString();
    }
}
