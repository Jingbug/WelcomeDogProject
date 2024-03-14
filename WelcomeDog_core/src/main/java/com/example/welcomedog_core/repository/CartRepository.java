package com.example.welcomedog_core.repository;


import com.example.welcomedog_core.entity.Cart;
import com.example.welcomedog_core.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // 회원번호로 장바구니 조회
    ArrayList<Cart> findCartsByMemberSeq(Member memberSeq);

    // 장바구니번호로 존재 여부 확인
    boolean existsByCartSeq(Long CartSeq);

    void deleteByMemberSeq(Member memberSeq);
}
