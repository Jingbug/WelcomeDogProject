package com.example.welcomedog_core.repository;

import com.example.welcomedog_core.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // 모든 주문 조회
    ArrayList<Order> findAll();

    // 주문번호로 주문리스트 조회
    Optional<Order> findOrderByOrderSeq(Long orderSeq);

    // 주문번호로 존재여부 확인
    boolean existsByOrderSeq(Long orderSeq);
}
