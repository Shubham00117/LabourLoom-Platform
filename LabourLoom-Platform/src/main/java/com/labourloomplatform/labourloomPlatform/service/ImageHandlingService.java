package com.labourloomplatform.labourloomPlatform.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;

public interface ImageHandlingService {

	ApiResponse uploadImage(Long UserId, MultipartFile image) throws IOException;

	byte[] serveImage(Long UserId) throws IOException;

}
