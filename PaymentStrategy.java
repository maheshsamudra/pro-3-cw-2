/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package icecreamshop;

/**
 *
 * @author maheshsamudra
 */
public interface PaymentStrategy {
    void processPayment(Order order);

    String getMethod();
}
