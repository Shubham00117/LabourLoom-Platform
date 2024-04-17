package com.labourloomplatform.labourloomPlatform.dto;

import java.time.LocalDateTime;

import com.labourloomplatform.labourloomPlatform.entity.TransactionStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {
	private Long transactionId;
	private TransactionStatus transactionStatus;
	private LocalDateTime transactionTimestamp;
}
