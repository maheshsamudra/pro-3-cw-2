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
public class Flavor {
    private int id;
    private String name;
    private String description;
    private double price;
    
    private Flavor(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Static method to get a list of predefined flavors
    public static List<Flavor> getPredefinedFlavors() {
        List<Flavor> predefinedFlavors = new ArrayList<>();
        predefinedFlavors.add(new Flavor("Fragola", 2.5, "Ice cream with strawberry flavor"));
        predefinedFlavors.add(new Flavor("Lampone", 2.0, "Ice cream made from Raspberry"));
        predefinedFlavors.add(new Flavor("Limone", 2.0, "Ice cream with Lemons"));
        predefinedFlavors.add(new Flavor("Pistacchio", 2.0, "Smooth and creamy pistacchio"));
        predefinedFlavors.add(new Flavor("Stracciatella", 2.0, "Smooth and creamy vanilla with chocolate chips"));
        predefinedFlavors.add(new Flavor("Cioccolato Fondente", 2.0, "Dark chocolate from italy"));
        // Add more flavors as needed
        return predefinedFlavors;
    }
}
