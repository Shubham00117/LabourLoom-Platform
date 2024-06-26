package com.labourloomplatform.labourloomPlatform.dto;

import com.labourloomplatform.labourloomPlatform.entity.Gender;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerUpdateRequestDto {

	@Nonnull
	private Long id;
	
	@Nonnull
	@Size(min = 2, max = 50, message = "First name can not be less than 2 characters and more than 50 characters")
	private String firstName;

	@Nonnull
	@Size(min = 2, max = 50, message = "Last name can not be less than 2 characters and more than 50 characters")
	private String lastName;

//	@Column(name = "gender", nullable = false, length = 10)
	private Gender gender;

	@Nonnull
	@Size(min = 10, max = 10, message = "contact must be of 10 digits")
	@Pattern(regexp = "^\\d{10}$")
	private String contact;

	@Size(min = 6, max = 100)
	@Email
	@Nullable
	private String email;

	@Nullable
	private String profilePicturePath;
	
	

}
