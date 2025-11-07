package com.titobiloluwa.orderservice.data.repository;

import com.titobiloluwa.orderservice.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
