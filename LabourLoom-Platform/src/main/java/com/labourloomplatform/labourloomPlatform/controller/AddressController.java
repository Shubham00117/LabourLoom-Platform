package com.labourloomplatform.labourloomPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labourloomplatform.labourloomPlatform.dto.AddressDto;
import com.labourloomplatform.labourloomPlatform.dto.AddressUpdateDto;
import com.labourloomplatform.labourloomPlatform.service.AddressService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/add")
	public ResponseEntity<?> addState(@RequestBody @Valid AddressDto addressDtO) {
		log.info("Address Controller - Add Address");
		return new ResponseEntity<>(addressService.addAddress(addressDtO), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAddressById(@PathVariable Long id) {
		return new ResponseEntity<>(addressService.deleteAddress(id), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateAddressById(@RequestBody @Valid AddressUpdateDto addressDto) {
		return new ResponseEntity<>(addressService.updateAddress(addressDto), HttpStatus.OK);
	}

}
