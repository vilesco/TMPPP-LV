// Save and retrive Users from users table of database
package com.example.Restaurant.repository;

import com.example.Restaurant.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer>{
	Optional<ApplicationUser> findByUsername(String username);
}
