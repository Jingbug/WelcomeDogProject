package com.example.welcomedog_admin.admin;

import com.example.welcomedog_core.dto.ItemDTO;
import com.example.welcomedog_core.dto.OrderDTO;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.entity.Order;
import com.example.welcomedog_core.entity.role.OrderStatus;
import com.example.welcomedog_admin.service.AdminService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    @DisplayName("Select All Member")
    void selectAllMember() {
        // when
        List<Member> members = adminService.selectAllMember();

        // then
        for (Member data: members) {
            System.out.println("----- Member List -----");
            System.out.println(data.getMemberId());
            System.out.println(data.getPassword());
            System.out.println(data.getMemberName());
            System.out.println("-----------------------");
        }
    }

    @Test
    @DisplayName("Select All Item")
    void selectAllItem() {
        // when
        List<Item> items = adminService.selectAllItem();

        // then
        for (Item data: items) {
            System.out.println("----- Item List -----");
            System.out.println(data.getItemName());
            System.out.println(data.getPrice());
            System.out.println(data.getItemInfo());
            System.out.println("---------------------");
        }
    }

    @Test
    @DisplayName("Select All Order")
    void selectAllOrder() {
        // when
        List<Order> orders = adminService.selectAllOrder();

        // then
        for (Order data: orders) {
            System.out.println("----- Order List -----");
            System.out.println(data.getStatus());
            System.out.println(data.getAddr());
            System.out.println(data.getDetailAddr());
            System.out.println("----------------------");
        }
    }

    @Test
    @DisplayName("Update OrderStatus")
    void updateOrderStatus() {
        // given
        OrderDTO.Request request = new OrderDTO.Request();
        request.setOrderSeq(1L);
        request.setStatus(OrderStatus.PREPARING);

        // when
        boolean result = adminService.updateOrderStatus(request);

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Add Item")
    void reg() {
        // given
        ItemDTO.Request request = new ItemDTO.Request();
        request.setItemName("itemA");
        request.setItemImg("~");
        request.setPrice(10000);
        request.setItemInfo("This is itemA");

        // when
        adminService.reg(request);
    }
}
