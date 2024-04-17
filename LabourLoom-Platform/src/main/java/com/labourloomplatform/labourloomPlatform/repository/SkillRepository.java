package com.labourloomplatform.labourloomPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labourloomplatform.labourloomPlatform.entity.Skill;
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	List<Skill> findByCategoryId(Long categoryId);

}
