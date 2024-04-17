package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labourloomplatform.labourloomPlatform.customException.AdminException;
import com.labourloomplatform.labourloomPlatform.customException.ResourceNotFoundException;
import com.labourloomplatform.labourloomPlatform.dto.AdminDTO;
import com.labourloomplatform.labourloomPlatform.dto.AdminSigninDTO;
import com.labourloomplatform.labourloomPlatform.dto.AdminSigninResponseDTO;
import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.entity.Admin;
import com.labourloomplatform.labourloomPlatform.repository.AdminRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AdminRepository adminRepo;

	@Override
	public AdminSigninResponseDTO register(@Valid AdminSigninDTO adminDetails) {
		Admin admin = mapper.map(adminDetails, Admin.class);
		adminRepo.save(admin);
		return mapper.map(admin, AdminSigninResponseDTO.class);
	}
	
	@Override
	public AdminSigninResponseDTO signin(@Valid AdminSigninDTO adminCredentials) {
		Admin admin = adminRepo.findByUserNameAndPassword(adminCredentials.getUserName(), adminCredentials.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("AUTHENTICATION FAILED : Incorrect user name or password"));
		return mapper.map(admin, AdminSigninResponseDTO.class);
		
	}
	
	@Override
	public ApiResponse deleteById(Long id) {
		Admin admin = adminRepo.findById(id).orElseThrow(() -> new AdminException("Invalid admin ID"));
		adminRepo.delete(admin);
		return new ApiResponse("Admin with username " + admin.getUserName() + " deleted Permanantly!");
	}

	@Override
	public AdminDTO getAdminById(Long id) {
		Admin admin = adminRepo.findById(id).orElseThrow(() -> new AdminException("Invalid admin ID"));
		return mapper.map(admin, AdminDTO.class);
	}

	@Override
	public List<AdminDTO> getListOfAllAdmin() {
		List<Admin> adminList = adminRepo.findAll();
		if(adminList.isEmpty())
			throw new AdminException("No Admins available");
		return adminList.stream().map(admin -> mapper.map(admin, AdminDTO.class)).collect(Collectors.toList());
	}

}
