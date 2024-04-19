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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import static org.mockito.BDDMockito.given;



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
                .andExpect(jsonPath("$.controlNumber").value(1));
    }

    @Test
    public void testGetOrdersWithFilters() throws Exception {
        Order order = new Order();
        order.setOrderId(1L);
        order.setProductName("Notebook");
        order.setUnitPrice(new BigDecimal("1200.00"));
        order.setQuantity(1);
        order.setRegistrationDate(new Date());
        order.setControlNumber(101);
        order.setClientId(1L);
        order.setTotalPrice(new BigDecimal("1200.00"));
        List<Order> allOrders = Arrays.asList(order);
        given(orderService.findOrdersWithFilters(1L, null, "Notebook",
                101, new BigDecimal("1200.00"), 1, 1L,
                new BigDecimal("1200.00"))).willReturn(allOrders);
        mockMvc.perform(MockMvcRequestBuilders.get("/pedidos/filtro")
                        .param("orderId", "1")
                        .param("productName", "Notebook")
                        .param("controlNumber", "101")
                        .param("unitPrice", "1200.00")
                        .param("quantity", "1")
                        .param("clientId", "1")
                        .param("totalPrice", "1200.00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].orderId").value(1))
                .andExpect(jsonPath("$[0].productName").value("Notebook"))
                .andExpect(jsonPath("$[0].unitPrice").value(1200))
                .andExpect(jsonPath("$[0].quantity").value(1))
                .andExpect(jsonPath("$[0].clientId").value(1))
                .andExpect(jsonPath("$[0].totalPrice").value(1200.00));
    }
}