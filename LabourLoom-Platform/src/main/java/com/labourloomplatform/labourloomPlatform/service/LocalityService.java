package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;
import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.LocalityDTO;
import com.labourloomplatform.labourloomPlatform.dto.LocalityResponceDTO;

import jakarta.validation.Valid;

public interface LocalityService {

	ApiResponse addLocality(@Valid LocalityDTO localityDTO);

	List<LocalityResponceDTO>getAllLocalitiesByCityId(Long id);
	
	LocalityResponceDTO getLocalityById(Long id);

	List<LocalityResponceDTO> getAllLocalies();

	ApiResponse deleteLocalityById(Long id);

	ApiResponse deleteAllLocalities();

	LocalityResponceDTO updateLocality(Long localityId, @Valid LocalityDTO localityDTO);

	Long getPin(Long id);


}
