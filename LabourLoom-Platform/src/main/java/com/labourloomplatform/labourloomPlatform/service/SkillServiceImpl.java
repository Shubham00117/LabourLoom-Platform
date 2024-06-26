package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labourloomplatform.labourloomPlatform.customException.ResourceNotFoundException;
import com.labourloomplatform.labourloomPlatform.customException.WorkerException;
import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.SkillAddDto;
import com.labourloomplatform.labourloomPlatform.dto.SkillDTO;
import com.labourloomplatform.labourloomPlatform.dto.SkillResponseDTO;
import com.labourloomplatform.labourloomPlatform.dto.WorkerResponseDTO;
import com.labourloomplatform.labourloomPlatform.entity.Category;
import com.labourloomplatform.labourloomPlatform.entity.Skill;
import com.labourloomplatform.labourloomPlatform.entity.Worker;
import com.labourloomplatform.labourloomPlatform.entity.WorkerStatus;
import com.labourloomplatform.labourloomPlatform.repository.CategoryRepository;
import com.labourloomplatform.labourloomPlatform.repository.SkillRepository;
import com.labourloomplatform.labourloomPlatform.repository.WorkerRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillRepository skillRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private WorkerRepository workerRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<SkillResponseDTO> getAllSkillsByCategoryId(Long categoryid) {
		List<Skill> list = skillRepo.findByCategoryId(categoryid);
		list.forEach(skill -> {

			System.out.println(skill.getSkillName());
		});
		return list.stream().map(skill -> mapper.map(skill, SkillResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse addSkill(@Valid SkillDTO skillDTO) {
		Category category = categoryRepo.findById(skillDTO.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID"));
		Skill skill = mapper.map(skillDTO, Skill.class);
		category.addSkill(skill);
		Skill saveSkill = skillRepo.save(skill);
		return new ApiResponse("Skill " + saveSkill.getSkillName() + " Added Successfully...");
	}

	@Override
	public ApiResponse deleteSkillById(Long id) {
		Skill skill = skillRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Skill ID"));
		skillRepo.delete(skill);
		return new ApiResponse("Skill " + skill.getSkillName() + " Delete Successfully...");
	}

	@Override
	public ApiResponse deleteAllSkills() {
		skillRepo.deleteAll();
		return new ApiResponse("Delete All Skills");
	}

	@Override
	public SkillResponseDTO updateSkill(Long skillId, @Valid SkillDTO skillDTO) {
		Skill skill = skillRepo.findById(skillId).orElseThrow(() -> new ResourceNotFoundException("Invalid Skill ID"));
		Category category = categoryRepo.findById(skillDTO.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID"));
		mapper.map(skillDTO, skill);
		category.addSkill(skill);
		return mapper.map(skill, SkillResponseDTO.class);
	}

	@Override
	public SkillResponseDTO getSkillById(Long id) {
		Skill skill = skillRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Skill ID"));
		return mapper.map(skill, SkillResponseDTO.class);
	}

	@Override
	public ApiResponse addRegSkills(SkillAddDto skillAddDto) {
		Worker worker = workerRepo.findById(skillAddDto.getWorkerId())
				.orElseThrow(() -> new WorkerException("Invalid worker ID"));
		List<Skill> skills = skillRepo.findAllById(skillAddDto.getSkillIds());
		skills.stream().forEach(skill -> worker.addSkill(skill));
		worker.setStatus(WorkerStatus.ACTIVE);
		return new ApiResponse(" Skill added Successfully ");							
	}



	@Override
	public List<WorkerResponseDTO> getWorkers(Long id) {
		Skill skill=skillRepo.findById(id).orElseThrow(() -> new WorkerException("Invalid skill ID"));
		Set<Worker> workers=skill.getWorkers();
		
		return workers.stream().map(worker->mapper.map(worker,WorkerResponseDTO.class)).collect(Collectors.toList());
	}
	@Override
	public List<SkillResponseDTO> getAllSkills() {
		return skillRepo.findAll().stream().map(skill -> mapper.map(skill, SkillResponseDTO.class))
				.collect(Collectors.toList());

	}

}
