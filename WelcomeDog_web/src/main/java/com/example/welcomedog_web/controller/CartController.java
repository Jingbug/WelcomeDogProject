package com.example.welcomedog_web.controller;

import com.example.welcomedog_core.dto.CartDTO;
import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Cart;
import com.example.welcomedog_web.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public String add(@ModelAttribute CartDTO.Request request) {
        cartService.add(request);
        return "page/main";
    }

    @PostMapping("/myList")
    public String myCartList(@ModelAttribute MemberDTO.Request request, Model model) {
        List<Cart> carts = cartService.findMyCart(request);
        if (carts == null) {
            return "/page/main";
        } else {
            model.addAttribute("carts", carts);
            return "page/cart";
        }
    }
}
