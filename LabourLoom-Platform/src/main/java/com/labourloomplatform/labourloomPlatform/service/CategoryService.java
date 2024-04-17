package com.labourloomplatform.labourloomPlatform.service;

import java.util.List;

import com.labourloomplatform.labourloomPlatform.dto.ApiResponse;
import com.labourloomplatform.labourloomPlatform.dto.CategoryDTO;
import com.labourloomplatform.labourloomPlatform.dto.SkillDTO;

import jakarta.validation.Valid;

public interface CategoryService {
	
	List<CategoryDTO> getAllCategories();

	
	CategoryDTO updateCategory(Long id ,@Valid CategoryDTO categoryDTO);
	
	ApiResponse deteleCategoryById(Long id);

	ApiResponse add(CategoryDTO category);

	ApiResponse delete(Long categoryId);

	ApiResponse update(CategoryDTO category);

	List<SkillDTO> getSkillsByCategoryId(Long categoryId);

	CategoryDTO getById(Long categoryId);

}
