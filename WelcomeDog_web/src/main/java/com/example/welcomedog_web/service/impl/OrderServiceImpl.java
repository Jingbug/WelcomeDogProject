package com.example.welcomedog_web.service.impl;

import com.example.welcomedog_core.dto.OrderDTO;
import com.example.welcomedog_core.entity.Cart;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.repository.CartRepository;
import com.example.welcomedog_core.repository.ItemRepository;
import com.example.welcomedog_core.repository.MemberRepository;
import com.example.welcomedog_core.repository.OrderRepository;
import com.example.welcomedog_web.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    // 주문 생성
    @Override
    @Transactional
    public boolean createOrder(OrderDTO.Request request) {
        Optional<Member> byMemberId = memberRepository.findByMemberId(request.getMemberId());
        if (byMemberId.isPresent()) {
            Member member = byMemberId.get();
            List<Cart> cartsByMemberSeq = cartRepository.findCartsByMemberSeq(member);

            request.setMemberSeq(member);

            int totalPrice = 0;
            int totalItemCNT = 0;

            System.out.println("cartsByMemberSeq = " + cartsByMemberSeq.size());
            for (Cart cart : cartsByMemberSeq) {
                System.out.println("cart.getCartItemCNT() = " + cart.getCartItemCNT());
                Optional<Item> itemByItemSeq = itemRepository.findItemByItemSeq(cart.getItemSeq().getItemSeq());
                if (itemByItemSeq.isPresent()) {
                    Item item = itemByItemSeq.get();
                    int sumItem = item.getPrice() * cart.getCartItemCNT();
                    totalItemCNT += cart.getCartItemCNT();
                    totalPrice += sumItem;
                }
            }

            request.setItemCNT(totalItemCNT);
            request.setTotalPrice(totalPrice);

            orderRepository.save(request.toEntity(request));
            cartRepository.deleteByMemberSeq(member);

            return true;
        } else {
            throw new NullPointerException("Member Not Found");
        }
    }

    // 주문내역 확인
    @Override
    public boolean findOrder(Long orderSeq) {
        return orderRepository.existsByOrderSeq(orderSeq);
    }
}