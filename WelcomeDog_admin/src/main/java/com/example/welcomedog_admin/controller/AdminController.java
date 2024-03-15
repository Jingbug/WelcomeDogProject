package com.example.welcomedog_admin.controller;

import com.example.welcomedog_admin.service.AdminService;
import com.example.welcomedog_core.dto.CartDTO;
import com.example.welcomedog_core.dto.ItemDTO;
import com.example.welcomedog_core.dto.OrderDTO;
import com.example.welcomedog_core.entity.Item;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_core.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @GetMapping("/selectMemberList")
    public String selectAllMember(Model model) {
        System.out.println("Member List");
        List<Member> members = adminService.selectAllMember();
        model.addAttribute("allMember", members);

        return "page/selectMemberList";
    }

    @GetMapping("/selectItemList")
    public String selectAllItem(Model model) {
        List<Item> items = adminService.selectAllItem();
        model.addAttribute("allItem", items);
        return "page/selectItemList";
    }

    @GetMapping("/selectOrderList")
    public String selectAllOrder(Model model) {
        List<Order> orders = adminService.selectAllOrder();
        model.addAttribute("allOrder", orders);
        return "page/selectOrderList";
    }
    @PostMapping("/orderStatusUpdate")
    public String orderStatusUpdate(@ModelAttribute OrderDTO.Request request) {
        boolean result = adminService.updateOrderStatus(request);
        return "page/selectOrderList";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute ItemDTO.Request request) {
        adminService.reg(request);
        return "redirect:/admin/selectItemList";
    }
}
