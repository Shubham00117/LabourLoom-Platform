package com.labourloomplatform.labourloomPlatform.dto;

import com.labourloomplatform.labourloomPlatform.entity.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninResponse {
private Long id;
private String firstName;
private String lastName;
private Gender gender;
private String contact;
}
