package com.labourloomplatform.labourloomPlatform.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labourloomplatform.labourloomPlatform.dto.AddressDto;
import com.labourloomplatform.labourloomPlatform.dto.AddressUpdateDto;
import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.entity.Address;
import com.labourloomplatform.labourloomPlatform.entity.Customer;
import com.labourloomplatform.labourloomPlatform.entity.Locality;
import com.labourloomplatform.labourloomPlatform.repository.AddressRepository;
import com.labourloomplatform.labourloomPlatform.repository.CustomerRepository;
import com.labourloomplatform.labourloomPlatform.repository.LocalityRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private LocalityRepository localityRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addAddress(@Valid AddressDto addressDtO) {
		Address address=mapper.map(addressDtO, Address.class);
		Locality locality=localityRepo.findById(addressDtO.getLocalityId()).orElseThrow(() -> new RuntimeException("Invalid locality ID"));
		Customer customer=customerRepo.findById(addressDtO.getCustomerId()).orElseThrow(() -> new RuntimeException("Invalid Customer ID"));
		addressRepo.save(address);
		locality.addAddress(address);
		customer.addAddress(address);
		return  new ApiResponse(" Address Added Successfully...");
	}

	@Override
	public ApiResponse deleteAddress(Long id) {
		Address address=addressRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid address ID"));
		addressRepo.delete(address);
		return new ApiResponse(" Address deleted Successfully...");
	}

	@Override
	public ApiResponse updateAddress(@Valid AddressUpdateDto addressDto) {
		
		Address address = addressRepo.findById(addressDto.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + addressDto.getAddressId()));
		 if (addressDto.getLane1() != null) {
	            address.setLane1(addressDto.getLane1());
	        }
	        if (addressDto.getLane2() != null) {
	            address.setLane2(addressDto.getLane2());
	        }
	        if (addressDto.getLane3() != null) {
	            address.setLane3(addressDto.getLane3());
	        }
	        if (addressDto.getLandMark() != null) {
	            address.setLandMark(addressDto.getLandMark());
	        }
	        if (addressDto.getLocalityId() != null) {
	        	Locality locality=localityRepo.findById(addressDto.getLocalityId()).orElseThrow(() -> new RuntimeException("Invalid locality ID"));
	        	locality.addAddress(address);
	        }
	        if (addressDto.getCustomerId() != null) {
	        	Customer customer=customerRepo.findById(addressDto.getCustomerId()).orElseThrow(() -> new RuntimeException("Invalid Customer ID"));
	        	customer.addAddress(address);
	        }
		return new ApiResponse(" Address updated Successfully...");
	}
	}
	
	


