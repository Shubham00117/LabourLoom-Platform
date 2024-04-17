package com.labourloomplatform.labourloomPlatform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labourloomplatform.labourloomPlatform.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Optional<Customer> findByContactAndPassword(String contact, String password);

}
