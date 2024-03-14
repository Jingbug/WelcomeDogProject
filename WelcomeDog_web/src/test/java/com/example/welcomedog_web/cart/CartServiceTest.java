package com.example.welcomedog_web.cart;

import com.example.welcomedog_core.dto.CartDTO;
import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Cart;
import com.example.welcomedog_web.service.CartService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CartServiceTest {

    @Autowired
    CartService cartService;

    @Test
    @DisplayName("Add Item to Cart")
    void add() {
        // given
        CartDTO.Request request = new CartDTO.Request();
        request.setCartItemCNT(3);
        request.setMemberId("ysm0419");
        request.setItemName("itemA");

        // when
        boolean result = cartService.add(request);

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("My Cart List")
    void myCart() {
        // given
        MemberDTO.Request request = new MemberDTO.Request();
        request.setMemberId("ysm0419");

        // when
        List<Cart> myCart = cartService.findMyCart(request);

        // then
        for (int i=0; i< myCart.size(); i++) {
            System.out.println(myCart.get(i));
        }
    }

    @Test
    @DisplayName("Delete Cart")
    void delete() {
        boolean result = cartService.delete(1L);

        Assertions.assertThat(result).isEqualTo(true);
    }
}
