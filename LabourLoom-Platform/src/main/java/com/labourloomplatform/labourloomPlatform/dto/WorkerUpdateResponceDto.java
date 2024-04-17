package com.labourloomplatform.labourloomPlatform.dto;

import com.labourloomplatform.labourloomPlatform.entity.Gender;
import com.labourloomplatform.labourloomPlatform.entity.WorkerStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class WorkerUpdateResponceDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private Gender gender;
	private WorkerStatus status;
	private String profilePicturePath;
}