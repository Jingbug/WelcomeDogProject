package com.example.welcomedog_core.repository;


import com.example.welcomedog_core.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // 상품이름으로 정보 조회
    Optional<Item> findByItemName(String itemName);

    // 모든 상품 조회
    ArrayList<Item> findAll();

    // 상품번호로 존재 여부 확인
    boolean existsByItemSeq(Long itemSeq);

    Optional<Item> findItemByItemSeq(Long itemSeq);
}
