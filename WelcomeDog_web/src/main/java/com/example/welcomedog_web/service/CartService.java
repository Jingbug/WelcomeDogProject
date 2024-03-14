package com.example.welcomedog_web.service;


import com.example.welcomedog_core.dto.CartDTO;
import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Cart;

import java.util.List;

public interface CartService {
    boolean add(CartDTO.Request request);
    boolean findCart(Long cartSeq);
    List<Cart> findMyCart(MemberDTO.Request request);

    boolean delete(Long memberSeq);
}
