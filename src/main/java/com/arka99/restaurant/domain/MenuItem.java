package com.arka99.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
    private int id;
    private String name;
    private String description;
    private MenuCategory category;
    private double price;

    public String toString() {
        return (this.name + " (" + this.price + ")");
    }


}
