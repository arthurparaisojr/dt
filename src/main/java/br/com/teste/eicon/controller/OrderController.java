package br.com.teste.eicon.controller;

import br.com.teste.eicon.model.Order;
import br.com.teste.eicon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        if (orderService.findByControlNumber(order.getControlNumber()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping(value = "/filtro", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Order> getOrders(
            @RequestParam(required = false) Long orderId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date registrationDate,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Integer controlNumber,
            @RequestParam(required = false) BigDecimal unitPrice,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Long clientId,
            @RequestParam(required = false) BigDecimal totalPrice) {
        return orderService.findOrdersWithFilters(orderId, registrationDate, productName, controlNumber, unitPrice, quantity, clientId, totalPrice);
    }
}