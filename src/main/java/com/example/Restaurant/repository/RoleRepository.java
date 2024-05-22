// Save and retrive Role from roles table of database
package com.example.Restaurant.repository;

import com.example.Restaurant.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByAuthority(String authority);
	
}
