package com.example.welcomedog_web.item;

import com.example.welcomedog_core.dto.ItemDTO;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_web.service.ItemService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemServiceTest {

    @Autowired
    ItemService itemService;
    
    @Test
    void findItem() {
        Item item = itemService.findItem(1L);
        System.out.println("item.getItemName() = " + item.getItemName());
    }
}
