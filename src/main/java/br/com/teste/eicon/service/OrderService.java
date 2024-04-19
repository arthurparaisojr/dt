package br.com.teste.eicon.service;

import br.com.teste.eicon.model.Order;
import br.com.teste.eicon.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findByControlNumber(Integer controlNumber) {
        return orderRepository.findByControlNumber(controlNumber);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}