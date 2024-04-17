package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;

import com.labourloomplatform.labourloomPlatform.dto.AdminDTO;
import com.labourloomplatform.labourloomPlatform.dto.AdminSigninDTO;
import com.labourloomplatform.labourloomPlatform.dto.AdminSigninResponseDTO;
import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;

import jakarta.validation.Valid;

public interface AdminService {

	AdminSigninResponseDTO register(@Valid AdminSigninDTO adminDetails);
	
	AdminSigninResponseDTO signin(@Valid AdminSigninDTO adminCredentials);
	
	ApiResponse deleteById(Long id);

	AdminDTO getAdminById(Long id);

	List<AdminDTO> getListOfAllAdmin();
	
}
