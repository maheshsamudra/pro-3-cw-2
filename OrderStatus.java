/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package icecreamshop;

/**
 *
 * @author maheshsamudra
 */
public interface OrderStatus {
    void confirmOrder(Order order);

    void deliverOrder(Order order);

    void cancelOrder(Order order);
}
