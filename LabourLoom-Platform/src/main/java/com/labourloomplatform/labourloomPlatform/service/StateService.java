package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;

import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.StateDTO;

import jakarta.validation.Valid;

public interface StateService {
	ApiResponse addState( @Valid StateDTO state);

	StateDTO getStateById(Long id);

	ApiResponse deleteStateById(Long id);

	ApiResponse deleteAllStates();

	StateDTO updateState(Long stateId, @Valid StateDTO stateDTO);

	List<StateDTO> getAllStates();

}
