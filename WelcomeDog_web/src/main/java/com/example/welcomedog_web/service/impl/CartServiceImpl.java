package com.example.welcomedog_web.service.impl;

import com.example.welcomedog_core.dto.CartDTO;
import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Cart;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.repository.CartRepository;
import com.example.welcomedog_core.repository.ItemRepository;
import com.example.welcomedog_core.repository.MemberRepository;
import com.example.welcomedog_web.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public boolean add(CartDTO.Request request) {
        Optional<Item> byItemId = itemRepository.findByItemName(request.getItemName());
        Optional<Member> byMemberId = memberRepository.findByMemberId(request.getMemberId());

        if (byMemberId.isPresent() && byItemId.isPresent()) {
            Item item = byItemId.get();
            Member member = byMemberId.get();

            request.setItemSeq(item);
            request.setMemberSeq(member);
            cartRepository.save(request.toEntity(request));

            return true;
        } else {
            throw new NullPointerException("Not Found");
        }
    }

    @Override
    public boolean findCart(Long cartSeq) {
        return cartRepository.existsByCartSeq(cartSeq);
    }

    @Override
    public List<Cart> findMyCart(MemberDTO.Request request) {
        Optional<Member> byMemberSeq = memberRepository.findByMemberId(request.getMemberId());
        Member member = byMemberSeq.get();
        ArrayList<Cart> cart = cartRepository.findCartsByMemberSeq(member);
        return  cart;
    }

    @Override
    @Transactional
    public boolean delete(Long memberSeq) {
        Optional<Member> memberByMemberSeq = memberRepository.findMemberByMemberSeq(memberSeq);
        Member member = memberByMemberSeq.get();
        cartRepository.deleteByMemberSeq(member);
        return true;
    }
}
