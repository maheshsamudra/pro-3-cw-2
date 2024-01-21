/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icecreamshop;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


/**
 *
 * @author maheshsamudra
 */
public class IceCream {
    private Flavor flavor;
    private List<Topping> toppings;
    private List<Syrup> syrups;

    private IceCream(Flavor flavor, List<Topping> toppings, List<Syrup> syrups) {
        this.flavor = flavor;
        this.toppings = toppings;
        this.syrups = syrups;
    }
    
    // Method to calculate the total price of the ice cream order
    private double calculateTotalPrice() {
        double totalPrice = flavor.getPrice();

        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }

        for (Syrup syrup : syrups) {
            totalPrice += syrup.getPrice();
        }

        return totalPrice;
    }

    // Getter for ice cream details
    public String getDetails() {
        // Create a string representation of the ice cream details
        // Include flavor, toppings, syrups, and total price
        // You can customize this based on your specific requirements
        
        
        StringJoiner addedToppings = new StringJoiner(", ");
        
        for (Topping topping : toppings) {
            addedToppings.add(topping.getName());
        }
        
        StringJoiner addedSyrups = new StringJoiner(", ");
        
        for (Syrup syrup : syrups) {
            addedSyrups.add(syrup.getName());
        }


        return "Flavor: " + flavor.getName() +
                "\nToppings: " + addedToppings.toString() +
                "\nSyrups: " + addedSyrups.toString() +
                "\nTotal Price: $" + calculateTotalPrice();
    }

    // IceCreamBuilder class for building IceCream objects
    public static class IceCreamBuilder {
        private Flavor flavor;
        private List<Topping> toppings;
        private List<Syrup> syrups;

        public IceCreamBuilder(Flavor flavor) {
            this.flavor = flavor;
            this.toppings = new ArrayList<>();
            this.syrups = new ArrayList<>();
        }

        public IceCreamBuilder addTopping(Topping topping) {
            toppings.add(topping);
            return this;
        }

        public IceCreamBuilder addSyrup(Syrup syrup) {
            syrups.add(syrup);
            return this;
        }

        public IceCream build() {
            return new IceCream(flavor, toppings, syrups);
        }
    }

    // Method to add a topping to the ice cream
    public void addTopping(Topping topping) {
        // Implementation for adding a topping
        toppings.add(topping);
    }

    // Method to add a syrup to the ice cream
    public void addSyrup(Syrup syrup) {
        // Implementation for adding a syrup
        syrups.add(syrup);
    }
}
