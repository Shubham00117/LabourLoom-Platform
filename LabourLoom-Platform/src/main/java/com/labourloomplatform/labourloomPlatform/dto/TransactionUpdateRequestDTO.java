package com.labourloomplatform.labourloomPlatform.dto;

import com.labourloomplatform.labourloomPlatform.entity.TransactionStatus;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class TransactionUpdateRequestDTO {
	private Long  orderId;
	private String transactionId;
	private TransactionStatus transactionStatus;
}
