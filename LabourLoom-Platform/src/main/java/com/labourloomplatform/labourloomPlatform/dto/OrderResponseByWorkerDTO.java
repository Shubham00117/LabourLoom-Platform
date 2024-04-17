package com.labourloomplatform.labourloomPlatform.dto;

import java.time.LocalDateTime;

import com.labourloomplatform.labourloomPlatform.entity.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseByWorkerDTO {
	private Long id;
	private String title;
	private String description;
	private OrderStatus status;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String address; 
}
