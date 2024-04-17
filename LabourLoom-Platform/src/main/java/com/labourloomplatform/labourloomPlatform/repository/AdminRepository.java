package com.labourloomplatform.labourloomPlatform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labourloomplatform.labourloomPlatform.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Optional<Admin> findByUserNameAndPassword(String userName, String password);

}
