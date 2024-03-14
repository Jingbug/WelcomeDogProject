package com.example.welcomedog_web.service;

import com.example.welcomedog_core.entity.Item;

import java.util.List;

public interface ItemService {

    // 상품번호로 조회
    boolean existItem(Long itemSeq);

    // 모든 상품 조회
    List<Item> selectAllItem();

    Item findItem(Long itemSeq);
}
