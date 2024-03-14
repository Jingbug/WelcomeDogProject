package com.example.welcomedog_web.service.impl;

import com.example.welcomedog_core.dto.ItemDTO;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.repository.ItemRepository;
import com.example.welcomedog_web.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    // 상품번호로 조회
    @Override
    public boolean existItem(Long itemSeq) {
        return itemRepository.existsByItemSeq(itemSeq);
    }

    // 모든 상품 조회
    @Override
    public List<Item> selectAllItem() {
        ArrayList<Item> allItem = itemRepository.findAll();
        return allItem;
    }

    @Override
    public Item findItem(Long itemSeq) {
        Optional<Item> item = itemRepository.findItemByItemSeq(itemSeq);
        Item item1 = item.get();
        return item1;
    }
}
