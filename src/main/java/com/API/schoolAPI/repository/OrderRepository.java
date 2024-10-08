package com.API.schoolAPI.repository;

import com.API.schoolAPI.model.OrderModel;
import com.API.schoolAPI.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderModel, UUID> {
}
