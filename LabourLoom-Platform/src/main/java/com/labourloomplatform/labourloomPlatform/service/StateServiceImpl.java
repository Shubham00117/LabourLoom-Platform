package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labourloomplatform.labourloomPlatform.customException.ResourceNotFoundException;
import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.StateDTO;
import com.labourloomplatform.labourloomPlatform.entity.State;
import com.labourloomplatform.labourloomPlatform.repository.StateRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addState(StateDTO stateDTO) {
		State stateEntity = mapper.map(stateDTO, State.class);
		State savedState = stateRepo.save(stateEntity);
		return new ApiResponse("State " + savedState.getState() + " added Successfully...");
	}

	@Override
	public StateDTO getStateById(Long id) {
		return mapper.map(stateRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid State")),
				StateDTO.class);
	}

	@Override
	public ApiResponse deleteStateById(Long id) {
		State state = stateRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid State ID"));
		stateRepo.delete(state);
		return new ApiResponse("State " + state.getState() + " Deteleted Successfully...");
	}

	@Override
	public ApiResponse deleteAllStates() {
		stateRepo.deleteAll();
		return new ApiResponse("All states deleted successfully");
	}

	@Override
	public StateDTO updateState(Long stateId, StateDTO stateDTO) {
		State state = stateRepo.findById(stateId).orElseThrow(() -> new ResourceNotFoundException("Invalid State ID"));
		mapper.map(stateDTO, state);
		return mapper.map(state, StateDTO.class);
	}

	@Override
	public List<StateDTO> getAllStates() {
		return stateRepo.findAll().stream().map(state -> mapper.map(state, StateDTO.class)).collect(Collectors.toList());
	}

}
