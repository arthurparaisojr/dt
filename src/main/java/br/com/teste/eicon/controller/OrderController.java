package br.com.teste.eicon.controller;

import br.com.teste.eicon.model.Order;
import br.com.teste.eicon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        if (orderService.findByControlNumber(order.getControlNumber()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }
}