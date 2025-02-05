/*package com.stockapp.mapper;

import com.stockapp.domain.Order;
import com.stockapp.dto.order.OrderRequest;
import com.stockapp.dto.order.OrderResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.stockapp.util.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTest {

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void convertToEntity() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setFirstName(FIRST_NAME);
        orderRequest.setLastName(LAST_NAME);
        orderRequest.setCity(CITY);
        orderRequest.setAddress(ADDRESS);
        orderRequest.setEmail(ORDER_EMAIL);
        orderRequest.setPostIndex(POST_INDEX);
        orderRequest.setPhoneNumber(PHONE_NUMBER);
        orderRequest.setTotalPrice(TOTAL_PRICE);

        Order order = modelMapper.map(orderRequest, Order.class);
    }

    @Test
    public void convertToResponseDto() {
        Order order = new Order();
        order.setId(1L);

        OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
        assertEquals(order.getId(), orderResponse.getId());
    }
}
*/