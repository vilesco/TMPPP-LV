// Save and retrive Customers to Customer table of database
package com.example.Restaurant.repository;

import com.example.Restaurant.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Optional<Customer> findById(Integer id);
}
