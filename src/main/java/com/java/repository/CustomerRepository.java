package com.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

	@Query(value = "select * from customers where customer_id = ?", nativeQuery = true)
    public Customer findCustomersLogin (String customerId);
	
	@Query(value = "select * from customers where email = ?", nativeQuery = true)
	Optional<Customer> findByEmail(String email);
}
