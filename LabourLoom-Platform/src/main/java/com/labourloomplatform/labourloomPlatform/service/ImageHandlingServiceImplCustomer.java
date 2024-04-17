package com.labourloomplatform.labourloomPlatform.service;

import static org.apache.commons.io.FileUtils.readFileToByteArray;
import static org.apache.commons.io.FileUtils.writeByteArrayToFile;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.labourloomplatform.labourloomPlatform.customException.ApiException;
import com.labourloomplatform.labourloomPlatform.customException.ResourceNotFoundException;
import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.entity.Customer;
import com.labourloomplatform.labourloomPlatform.repository.CustomerRepository;

import jakarta.annotation.PostConstruct;

public class ImageHandlingServiceImplCustomer implements ImageHandlingService {

	@Value("${file.upload2.location}")
	private String uploadFolder;
	
	@Autowired
	private CustomerRepository customerRepo;

	
	@PostConstruct
	public void init() throws IOException {
		// Check if folder exists --yes --continue
		File folder = new File(uploadFolder);
		if (folder.exists()) {
			System.out.println("folder exists alrdy !");
		} else {
			// no --create a folder
			folder.mkdir();
			System.out.println("created a folder !");
		}
	}
	
	@Override
	public ApiResponse uploadImage(Long customerId, MultipartFile image) throws IOException {
		
		Customer customer =  customerRepo.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Invalid Customer Id"));
		  // Generate a unique file name based on the worker's ID
	    String fileName = "customerId_" + customerId ;
	    String path = uploadFolder.concat(fileName);
		System.out.println(path);
		writeByteArrayToFile(new File(path), image.getBytes());
		// set image path
		customer.setProfilePicturePath(fileName);
		customerRepo.save(customer);
		return new ApiResponse("Image file uploaded successfully for Customer id " + customerId);
	}

	@Override
	public byte[] serveImage(Long UserId) throws IOException {
	Customer customer =  customerRepo.findById(UserId).orElseThrow(()-> new ResourceNotFoundException("Invalid Customer Id"));
	String path =customer.getProfilePicturePath();
	if(path != null) {
		// path ---> File --> byte[]
		return readFileToByteArray(new File(uploadFolder.concat(path)));
	} else
		throw new ApiException("Image not yet assigned !!!!");
	}

}
