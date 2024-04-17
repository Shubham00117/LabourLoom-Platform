package com.labourloomplatform.labourloomPlatform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerLocalityRequestDTO {
	private Long workerId;
	private Long localityId;

}
