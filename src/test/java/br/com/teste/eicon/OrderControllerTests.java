package br.com.teste.eicon;

import br.com.teste.eicon.controller.OrderController;
import br.com.teste.eicon.model.Order;
import br.com.teste.eicon.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(OrderController.class)
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void testCreateOrder_Success() throws Exception {
        Order order = new Order();
        order.setControlNumber(1);
        order.setProductName("Product X");
        order.setUnitPrice(new BigDecimal("100.00"));
        order.setClientId(1L);
        order.setTotalPrice(new BigDecimal("100.00"));

        when(orderService.saveOrder(any(Order.class))).thenReturn(order);
        mockMvc.perform(post("/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"controlNumber\":\"001\",\"productName\":\"Product X\",\"unitPrice\":100,\"clientId\":1,\"totalPrice\":100}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.controlNumber").value("001"));
    }
}