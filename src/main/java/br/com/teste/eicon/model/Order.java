package br.com.teste.eicon.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(unique = true, nullable = false)
    private Integer controlNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    private int quantity = 1;

    @Column(name = "customer_id")
    private Long clientId;

    private BigDecimal totalPrice;

    public Order() {}

    @PrePersist
    public void calculateTotalPrice() {
        if (quantity > 5) {
            unitPrice = unitPrice.subtract(unitPrice.multiply(BigDecimal.valueOf(0.05)));
        }
        if (quantity >= 10) {
            unitPrice = unitPrice.subtract(unitPrice.multiply(BigDecimal.valueOf(0.10)));
        }
        totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}