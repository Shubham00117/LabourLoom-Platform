package com.labourloomplatform.labourloomPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labourloomplatform.labourloomPlatform.entity.Locality;

public interface LocalityRepository extends JpaRepository<Locality, Long> {

	public List<Locality> findByCityId(Long cityId);
}
