/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icecreamshop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maheshsamudra
 */
public class Order {
    private IceCream iceCream;
    private String name;
    private int quantity;
    private LocalDateTime creationTime;
    private OrderStatus status;
    private double subtotal;
    private double total;
    private String deliveryAddress;
    private Customer customer;
    private PaymentStrategy paymentStrategy;
    private List<OrderObserver> observers;
    private MapAdapter mapAdapter;


    public Order(IceCream iceCream, String name, int quantity, LocalDateTime creationTime, OrderStatus status, Customer customer, PaymentStrategy paymentStrategy, MapAdapter mapAdapter) {
        this.iceCream = iceCream;
        this.name = name;
        this.quantity = quantity;
        this.creationTime = creationTime;
        this.status = status;
        this.deliveryAddress = customer.getAddress();
        this.customer = customer;
        this.paymentStrategy = paymentStrategy;
        this.observers = new ArrayList<>();
        this.mapAdapter = mapAdapter;

    }

    // Getter for order details
    public String getDetails() {
        return "Order Name: " + name +
                "\nQuantity: " + quantity +
                "\nCreation Time: " + creationTime +
                "\nStatus: " + status.getClass().getSimpleName() +
                "\nDelivery Address: " + deliveryAddress +
                "\nPayment Method: " + paymentStrategy.getMethod() +
                "\nDelivery Details: " + this.getDistanceAndDeliveryTime() +
                "\n" + iceCream.getDetails();
    }
    
    // Getter for order name
    public String getName() {
        return name;
    }

    // Setter for order name
    public void setStatus(String name) {
        this.name = name;
    }
    
    // Getter for ice cream in the order
    public IceCream getIceCream() {
        return iceCream;
    }

    // Setter for ice cream in the order
    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    // Getter for order status
    public OrderStatus getStatus() {
        return status;
    }

    // Setter for order status
    public void setStatus(OrderStatus status) {
        this.status = status;
        notifyObservers(); // Notify observers when the status changes
    }

    // Method to add an observer to the list
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    // Method to remove an observer from the list
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    // Method to notify all observers of a status change
    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    // Method to process payment using the selected payment strategy
    public void processPayment() {
        paymentStrategy.processPayment(this);
    }

    // Method to customize the order using the Chain of Responsibility pattern
    public void customizeOrder(OrderCustomization orderCustomization) {
        orderCustomization.process(this);
    }
    
    // Getter for delivery address
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    // Setter for delivery address
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    // Getter for customer
    public Customer getCustomer() {
        return customer;
    }

    // Setter for customer
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    // Getter for subtotal
    public double getSubtotal() {
        return subtotal;
    }

    // Setter for subtotal
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    // Getter for total
    public double getTotal() {
        return total;
    }

    // Setter for total
    public void setTotal(double total) {
        this.total = total;
    }
    
    // Getter for order creation time
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    // Setter for order creation time
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    // Getter for order quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for order quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter for payment strategy
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    // Setter for payment strategy
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void confirmOrder() {
        status.confirmOrder(this);
    }
    
    public void cancelOrder() {
        status.cancelOrder(this);
    }
    
    public void deliverOrder() {
        status.confirmOrder(this);
    }
    
    public MapAdapter getMapAdapter() {
        return mapAdapter;
    }
    
    public void setMapAdapter(MapAdapter mapAdapter) {
        this.mapAdapter = mapAdapter;
    }
    
    public String getDistanceAndDeliveryTime() {
        String destination = this.getDeliveryAddress();
        String source = "Shop Address";
        String distance = this.mapAdapter.getDistance(source, destination);
        String deliveryTime = this.mapAdapter.getDeliveryTime(source, destination);
        return "Distance: " + distance + ", Delivery Time: " + deliveryTime;
    }
}
