package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;

import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.CreateOrderDTO;
import com.labourloomplatform.labourloomPlatform.dto.OrderResponseDTO;
import com.labourloomplatform.labourloomPlatform.dto.TransactionUpdateRequestDTO;

public interface OrderService {
	
	public List<OrderResponseDTO> getAll(int pageNumber, int pageSize);	
	public OrderResponseDTO getById(Long orderId);
	public List<OrderResponseDTO> getAllByWorkerId(Long workerId);
	public List<OrderResponseDTO> getAllByCustomerId(Long customerId);
	
	public OrderResponseDTO createOrder(CreateOrderDTO orderDetails);
	public ApiResponse fulfillOrder(Long orderId);
	public ApiResponse cancelOrder(Long orderId);
	public ApiResponse suspendOrder(Long orderId);
	
	public ApiResponse updateTransaction(TransactionUpdateRequestDTO updateRequest);
}
