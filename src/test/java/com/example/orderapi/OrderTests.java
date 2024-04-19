package com.example.orderapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class OrderTests {

    @Test
    void testCalculateTotalPrice_Normal() {
        Order order = new Order();
        order.setUnitPrice(new BigDecimal("100.00"));
        order.setQuantity(1);
        order.calculateTotalPrice();
        assertEquals(new BigDecimal("100.00"), order.getTotalPrice(), "Total price should be correct without discount.");
    }

    @Test
    void testCalculateTotalPrice_Discount5() {
        Order order = new Order();
        order.setUnitPrice(new BigDecimal("100.00"));
        order.setQuantity(6);
        order.calculateTotalPrice();
        assertEquals(new BigDecimal("570.00"), order.getTotalPrice(), "Total price should be correct with 5% discount.");
    }

    @Test
    void testCalculateTotalPrice_Discount10() {
        Order order = new Order();
        order.setUnitPrice(new BigDecimal("100.00"));
        order.setQuantity(10);
        order.calculateTotalPrice();
        assertEquals(new BigDecimal("900.00"), order.getTotalPrice(), "Total price should be correct with 10% discount.");
    }
}