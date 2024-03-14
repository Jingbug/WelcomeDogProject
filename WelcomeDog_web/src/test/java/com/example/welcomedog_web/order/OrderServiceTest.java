package com.example.welcomedog_web.order;

import com.example.welcomedog_core.dto.OrderDTO;
import com.example.welcomedog_web.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    @DisplayName("Order Success")
    void createOrder() {
        // given
        OrderDTO.Request request = new OrderDTO.Request();
        request.setAddr("Seoul");
        request.setDetailAddr("GangNam");
        request.setName("SM");
        request.setRecipient_tel("010-1111-1111");
        request.setZipcode("111111");
        request.setMemberId("ysm0419");

        // when
        orderService.createOrder(request);
        boolean result = orderService.findOrder(1L);

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }
}
