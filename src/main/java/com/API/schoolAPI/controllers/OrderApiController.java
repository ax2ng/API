package com.API.schoolAPI.controllers;

import com.API.schoolAPI.model.OrderModel;
import com.API.schoolAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/orders")
public class OrderApiController {
    @Autowired
    private final OrderService orderService;

    public OrderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderModel> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public OrderModel getUniversityById(@PathVariable UUID id) {
        return orderService.findOrderById(id);
    }

    @PostMapping
    public OrderModel createUniversity(@RequestBody OrderModel order) {
        return orderService.addOrder(order);
    }

    @PutMapping("/{id}")
    public OrderModel updateUniversity(@PathVariable UUID id, @RequestBody OrderModel order) {
        order.setId(id);
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable UUID id) {
        orderService.deleteOrder(id);
    }
}
