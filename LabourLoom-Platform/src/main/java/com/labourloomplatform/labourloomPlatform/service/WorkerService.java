package com.labourloomplatform.labourloomPlatform.service;


import java.time.LocalDateTime;
import java.util.List;

import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.OrderResponseDTO;
import com.labourloomplatform.labourloomPlatform.dto.SigninRequest;
import com.labourloomplatform.labourloomPlatform.dto.SigninResponse;
import com.labourloomplatform.labourloomPlatform.dto.WorkerLocalityRequestDTO;
import com.labourloomplatform.labourloomPlatform.dto.WorkerRegistrationDto;
import com.labourloomplatform.labourloomPlatform.dto.WorkerUpdateRequestDto;
import com.labourloomplatform.labourloomPlatform.dto.WorkerUpdateResponceDto;
import com.labourloomplatform.labourloomPlatform.dto.WorkerResponseDTO;
import com.labourloomplatform.labourloomPlatform.dto.WorkerSkillsDTO;

import jakarta.validation.Valid;

public interface WorkerService {

	WorkerResponseDTO register(WorkerRegistrationDto workerDto);
	
	WorkerUpdateResponceDto updateWorker(WorkerUpdateRequestDto worker);
	
	String deleteByIdPermanently(Long id);

	String deleteById(Long id);
	
	SigninResponse authenticate(@Valid SigninRequest request);

	WorkerResponseDTO getWorkerDetails(Long id);

	List<WorkerResponseDTO> getAllWorkers(int pageNumber, int pageSize);
	
	List<WorkerResponseDTO> getAvailableWorkersBySlotAndSkill(Long skillId, LocalDateTime startTime, LocalDateTime endTime, int pageNumber, int pageSize);
	List<OrderResponseDTO> getAllConfirmedByWorkerId(Long workerId);
	ApiResponse updateSkillsByWorkerId(WorkerSkillsDTO workerSkills);
	ApiResponse updateLocalityByWorkerIdAndLocalityId(WorkerLocalityRequestDTO workerLocality);

}
