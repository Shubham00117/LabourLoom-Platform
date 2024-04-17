package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;

import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.CustomerResponceDto;
import com.labourloomplatform.labourloomPlatform.dto.CustomerSignUpRequest;
import com.labourloomplatform.labourloomPlatform.dto.CustomerUpdateDto;
import com.labourloomplatform.labourloomPlatform.dto.SigninRequest;
import com.labourloomplatform.labourloomPlatform.dto.SigninResponse;

import jakarta.validation.Valid;

public interface CustomerService {
	ApiResponse registerCustomer(CustomerSignUpRequest customer);

	String deleteByIdPermanently(Long Id);

	String deleteById(Long id);


	SigninResponse authenticate(@Valid SigninRequest request);

	CustomerResponceDto getCustomerDetails(Long id) ;

	List<CustomerResponceDto> getAllCustomers(int pageNumber, int pageSize);


	ApiResponse updateCustomer( CustomerUpdateDto customerDto);

	ApiResponse suspendCustomer(Long customerId);

	ApiResponse activateCustomer(Long customerId);


}
