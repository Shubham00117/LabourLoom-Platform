package com.labourloomplatform.labourloomPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labourloomplatform.labourloomPlatform.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
