package com.labourloomplatform.labourloomPlatform.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labourloomplatform.labourloomPlatform.entity.Order;
import com.labourloomplatform.labourloomPlatform.entity.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByWorkerId(Long workerId);
	public List<Order> findByCustomerId(Long customerId);
	public List<Order> findAllByStartTimeIsAndStatus(LocalDateTime startTime, OrderStatus status);
}
