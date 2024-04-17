package com.labourloomplatform.labourloomPlatform.service;


import com.labourloomplatform.labourloomPlatform.dto.AddressDto;
import com.labourloomplatform.labourloomPlatform.dto.AddressUpdateDto;
import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;


import jakarta.validation.Valid;

public interface AddressService {

	ApiResponse addAddress(@Valid AddressDto addressDtO);

	ApiResponse deleteAddress(Long id);

	ApiResponse  updateAddress(@Valid  AddressUpdateDto addressDto);

}
