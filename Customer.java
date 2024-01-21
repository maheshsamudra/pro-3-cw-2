/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icecreamshop;

import java.time.LocalDateTime;

/**
 *
 * @author maheshsamudra
 */
public class Customer implements OrderObserver  {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private boolean isMember;

    public Customer(String name, String address, String phoneNumber, boolean isMember) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isMember = isMember;
    }

    // Implementation of the update method from the OrderObserver interface
    @Override
    public void update(Order order) {
        System.out.println("Notification for customer " + name + ": Order status changed to " +
                order.getStatus().getClass().getSimpleName());
    }

    // Method to create an order
    public Order createOrder(IceCream iceCream, String name, int quantity, LocalDateTime creationTime,
                             OrderStatus status,
                             PaymentStrategy paymentStrategy, MapAdapter mapAdapter) {
        Order order = new Order(iceCream, name, quantity, creationTime, status, this, paymentStrategy, mapAdapter);
        order.addObserver(this);
        return order;
    }
    
    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter for isMember
    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean isMember) {
        this.isMember = isMember;
    }
    
    
}
