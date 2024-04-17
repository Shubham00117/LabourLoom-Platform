package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;

import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.CityDTO;
import com.labourloomplatform.labourloomPlatform.dto.CityResponseDTO;

import jakarta.validation.Valid;

public interface CityService {
	
	
	ApiResponse addCity( @Valid CityDTO cityDTO);

	CityResponseDTO getCityById(Long id);

	ApiResponse deleteCityById(Long id);

	ApiResponse deleteAllCitys();

	CityResponseDTO updateCity(Long id, @Valid CityDTO cityDTO);

	List<CityResponseDTO> getAllCitys();
	
	List<CityResponseDTO>getAllCitiesByStateId(Long stateId);

}
