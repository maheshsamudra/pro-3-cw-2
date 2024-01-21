/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icecreamshop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maheshsamudra
 */
public class Topping {
    private int id;
    private String name;
    private double price;
    private String description;

    private Topping(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
    
    // Static method to get a list of predefined toppings
    public static List<Topping> getPredefinedToppings() {
        List<Topping> predefinedToppings = new ArrayList<>();
        predefinedToppings.add(new Topping("Nuts", 0.5, "Crunchy nuts"));
        predefinedToppings.add(new Topping("Whipped Cream", 0.75, "Light and fluffy whipped cream"));
        predefinedToppings.add(new Topping("Sprinkles", 0.3, "Colorful sprinkles"));
        // Add more toppings as needed
        return predefinedToppings;
    }
}
