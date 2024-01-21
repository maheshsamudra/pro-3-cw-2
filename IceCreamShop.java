/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package icecreamshop;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author maheshsamudra
 */


// PendingOrderStatus class implementing OrderStatus for the "Pending" status
class PendingOrderStatus implements OrderStatus {
    @Override
    public void confirmOrder(Order order) {
        order.setStatus(new ConfirmedOrderStatus());
        System.out.println("Order confirmed: " + order.getName());
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver pending order: " + order.getName());
    }

    @Override
    public void cancelOrder(Order order) {
        order.setStatus(new CancelledOrderStatus());
        System.out.println("Order cancelled: " + order.getName());
    }
}

// ConfirmedOrderStatus class implementing OrderStatus for the "Confirmed" status
class ConfirmedOrderStatus implements OrderStatus {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Order is already confirmed: " + order.getName());
    }

    @Override
    public void deliverOrder(Order order) {
        order.setStatus(new DeliveredOrderStatus());
        System.out.println("Order delivered: " + order.getName());
    }

    @Override
    public void cancelOrder(Order order) {
        order.setStatus(new CancelledOrderStatus());
        System.out.println("Order cancelled: " + order.getName());
    }
}

// DeliveredOrderStatus class implementing OrderStatus for the "Delivered" status
class DeliveredOrderStatus implements OrderStatus {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Cannot confirm delivered order: " + order.getName());
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Order is already delivered: " + order.getName());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Cannot cancel delivered order: " + order.getName());
    }
}

// CancelledOrderStatus class implementing OrderStatus for the "Cancelled" status
class CancelledOrderStatus implements OrderStatus {
    @Override
    public void confirmOrder(Order order) {
        System.out.println("Cannot confirm cancelled order: " + order.getName());
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Cannot deliver cancelled order: " + order.getName());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order is already cancelled: " + order.getName());
    }
}

// ToppingCustomization class implementing OrderCustomization for adding toppings
class ToppingCustomization implements OrderCustomization {
    private Topping topping;

    public ToppingCustomization(Topping topping) {
        this.topping = topping;
    }

    @Override
    public void process(Order order) {
        order.getIceCream().addTopping(topping);
        System.out.println("Added " + topping.getName() + " topping to order: " + order.getName());
    }
}

// SyrupCustomization class implementing OrderCustomization for adding syrups
class SyrupCustomization implements OrderCustomization {
    private Syrup syrup;

    public SyrupCustomization(Syrup syrup) {
        this.syrup = syrup;
    }

    @Override
    public void process(Order order) {
        order.getIceCream().addSyrup(syrup);
        System.out.println("Added " + syrup.getName() + " syrup to order: " + order.getName());
    }
}

// CashOnDeliveryPaymentStrategy class implementing PaymentStrategy for cash on delivery
class CashOnDeliveryPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Order order) {
        // Logic for processing cash on delivery payment
        System.out.println("Processing Cash On Delivery payment for order: " + order.getName());
    }

    @Override
    public String getMethod() {
        return "Cash On Delivery";
    }
}

// CreditCardPaymentStrategy class implementing PaymentStrategy for credit card
class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Order order) {
        // Logic for processing credit card payment
        System.out.println("Processing Credit Card payment for order: " + order.getName());
    }

    @Override
    public String getMethod() {
        return "Credit Card";
    }
}

// Enum representing payment methods
enum PaymentMethod {
    CASH_ON_DELIVERY, CREDIT_CARD
}

// ConfirmOrderCommand class implementing Command for confirming an order
class ConfirmOrderCommand implements Command {
    private Order order;

    public ConfirmOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.confirmOrder();
    }
}

// DeliverOrderCommand class implementing Command for delivering an order
class DeliverOrderCommand implements Command {
    private Order order;

    public DeliverOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.deliverOrder();
    }
}

// CancelOrderCommand class implementing Command for canceling an order
class CancelOrderCommand implements Command {
    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.cancelOrder();
    }
}

// GiftWrappingDecorator class implementing Decorator for adding gift wrapping to an order
class GiftWrappingDecorator extends OrderDecorator {
    public GiftWrappingDecorator(Order order) {
        super(order);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nGift Wrapping: Yes";
    }
}

// OrderDecorator class for the Decorator pattern
abstract class OrderDecorator extends Order {
    private Order order;

    public OrderDecorator(Order order) {
        super(order.getIceCream(), order.getName(), order.getQuantity(), order.getCreationTime(),
                order.getStatus(),
                order.getCustomer(), order.getPaymentStrategy(), order.getMapAdapter());
        this.order = order;
    }

    @Override
    public String getDetails() {
        return order.getDetails();
    }
}


class GoogleMapsAdapter implements MapAdapter {
    private GoogleMapsService googleMapsService;

    public GoogleMapsAdapter(GoogleMapsService googleMapsService) {
        this.googleMapsService = googleMapsService;
    }

    @Override
    public String getDistance(String source, String destination) {
        return googleMapsService.calculateDistance(source, destination);
    }

    @Override
    public String getDeliveryTime(String source, String destination) {
        return googleMapsService.estimateDeliveryTime(source, destination);
    }
}

// IceCreamShop class for example usage
public class IceCreamShop {
    public static void main(String[] args) {
        List<Flavor> predefinedFlavors = Flavor.getPredefinedFlavors();
        List<Topping> predefinedToppings = Topping.getPredefinedToppings();
        List<Syrup> predefinedSyrups = Syrup.getPredefinedSyrups();

        // Selecting specific flavors, toppings, and syrups
        Flavor chocolate = predefinedFlavors.get(0);
        Flavor vanilla = predefinedFlavors.get(1);

        Topping nuts = predefinedToppings.get(0);
        Topping whippedCream = predefinedToppings.get(1);

        Syrup caramel = predefinedSyrups.get(0);
        Syrup chocolateSyrup = predefinedSyrups.get(1);

        // Using the IceCreamBuilder to create IceCream objects
        IceCream order1IceCream = new IceCream.IceCreamBuilder(chocolate)
                .addTopping(nuts)
                .addSyrup(caramel)
                .build();

        IceCream order2IceCream = new IceCream.IceCreamBuilder(vanilla)
                .addTopping(whippedCream)
                .addSyrup(chocolateSyrup)
                .build();
        
        // Creating a customer
        Customer customer = new Customer("John Doe", "165, Temple Road, Gampaha.", "077123456", true);

        // Creating payment strategy instances
        PaymentStrategy cashOnDeliveryPaymentStrategy = new CashOnDeliveryPaymentStrategy();
        PaymentStrategy creditCardPaymentStrategy = new CreditCardPaymentStrategy();
        
        GoogleMapsService googleMapsService = new GoogleMapsService();
        MapAdapter googleMapsAdapter = new GoogleMapsAdapter(googleMapsService);
        

        // Creating and saving an order for the customer with different payment strategies
        Order order1 = customer.createOrder(order1IceCream, "Special Order", 2, LocalDateTime.now(),
                new PendingOrderStatus(), cashOnDeliveryPaymentStrategy, googleMapsAdapter);

        Order order2 = customer.createOrder(order2IceCream, "Standard Order", 1, LocalDateTime.now(),
                new PendingOrderStatus(), creditCardPaymentStrategy, googleMapsAdapter);

        // Adding the customer as an observer to the orders
        order1.addObserver(customer);
        order2.addObserver(customer);

        // Customizing orders with Chain of Responsibility pattern
        ToppingCustomization toppingCustomization = new ToppingCustomization(predefinedToppings.get(0));
        SyrupCustomization syrupCustomization = new SyrupCustomization(predefinedSyrups.get(0));

        order1.customizeOrder(toppingCustomization);
        order2.customizeOrder(syrupCustomization);

        // Changing the order status, processing payments, and invoking commands
        OrderCommandInvoker commandInvoker = new OrderCommandInvoker();

        // Confirming the first order
        commandInvoker.setCommand(new ConfirmOrderCommand(order1));
        commandInvoker.executeCommand();

        // Delivering the second order
        commandInvoker.setCommand(new DeliverOrderCommand(order2));
        commandInvoker.executeCommand();

        // Cancelling the first order
        commandInvoker.setCommand(new CancelOrderCommand(order1));
        commandInvoker.executeCommand();

        // Adding gift wrapping to the second order using Decorator pattern
        order2 = new GiftWrappingDecorator(order2);

        // Displaying order details
        System.out.println(order1.getDetails());
        System.out.println("\n-----------------------------\n");
        System.out.println(order2.getDetails());
    }
}

