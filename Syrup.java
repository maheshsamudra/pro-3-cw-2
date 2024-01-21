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
public class Syrup {
    private int id;
    private String name;
    private double price;
    private String description;

    private Syrup(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter methods for syrup properties
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Static method to get a list of predefined syrups
    public static List<Syrup> getPredefinedSyrups() {
        List<Syrup> predefinedSyrups = new ArrayList<>();
        predefinedSyrups.add(new Syrup("Caramel", 1.0, "Sweet caramel drizzle"));
        predefinedSyrups.add(new Syrup("Chocolate Syrup", 1.25, "Rich chocolate syrup"));
        predefinedSyrups.add(new Syrup("Strawberry Syrup", 1.5, "Delicious strawberry syrup"));
        // Add more syrups as needed
        return predefinedSyrups;
    }
}
