package br.com.teste.eicon.repository;

import br.com.teste.eicon.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByControlNumber(Integer controlNumber);
    List<Order> findByOrderId(Long orderId);
    @Query("SELECT o FROM Order o WHERE " +
            "(:orderId IS NULL OR o.orderId = :orderId) AND " +
            "(:registrationDate IS NULL OR o.registrationDate = :registrationDate) AND " +
            "(:productName IS NULL OR o.productName = :productName) AND " +
            "(:controlNumber IS NULL OR o.controlNumber = :controlNumber) AND " +
            "(:unitPrice IS NULL OR o.unitPrice = :unitPrice) AND " +
            "(:quantity IS NULL OR o.quantity = :quantity) AND " +
            "(:clientId IS NULL OR o.clientId = :clientId) AND " +
            "(:totalPrice IS NULL OR o.totalPrice = :totalPrice)")
    List<Order> findWithDynamicQuery(
            @Param("orderId") Long orderId,
            @Param("registrationDate") Date registrationDate,
            @Param("productName") String productName,
            @Param("controlNumber") Integer controlNumber,
            @Param("unitPrice") BigDecimal unitPrice,
            @Param("quantity") Integer quantity,
            @Param("clientId") Long clientId,
            @Param("totalPrice") BigDecimal totalPrice);
}