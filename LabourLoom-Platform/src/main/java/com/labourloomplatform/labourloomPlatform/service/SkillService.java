package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;

import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.SkillAddDto;
import com.labourloomplatform.labourloomPlatform.dto.SkillDTO;
import com.labourloomplatform.labourloomPlatform.dto.SkillResponseDTO;
import com.labourloomplatform.labourloomPlatform.dto.WorkerResponseDTO;
import jakarta.validation.Valid;


public interface SkillService {
	
	ApiResponse addSkill(@Valid SkillDTO skillDTO );
	
	ApiResponse deleteSkillById(Long id);
	
	ApiResponse deleteAllSkills();
	
	ApiResponse addRegSkills(SkillAddDto skillAddDto);
	
	SkillResponseDTO getSkillById(Long id);
	
	SkillResponseDTO updateSkill(Long skillId,@Valid SkillDTO skillDTO );

	List<SkillResponseDTO> getAllSkills();
	
	List<SkillResponseDTO> getAllSkillsByCategoryId(Long categoryId);

	List<WorkerResponseDTO> getWorkers(Long id);
	

}
