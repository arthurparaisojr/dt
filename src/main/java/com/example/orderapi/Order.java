package com.example.orderapi;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String controlNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    private int quantity = 1;

    @Column(nullable = false)
    private Long clientId;

    private BigDecimal totalPrice;

    public Order() {}

    // Business logic for discounts and total price calculation
    @PrePersist
    private void calculateTotalPrice() {
        if (quantity > 5) {
            unitPrice = unitPrice.subtract(unitPrice.multiply(BigDecimal.valueOf(0.05)));
        }
        if (quantity >= 10) {
            unitPrice = unitPrice.subtract(unitPrice.multiply(BigDecimal.valueOf(0.10)));
        }
        totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    // Getters and setters are omitted for brevity
}