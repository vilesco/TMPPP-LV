package com.example.Restaurant.repository;

import com.example.Restaurant.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	Optional<Reservation> findById(Integer id);
	List<Reservation> findByCustomerID(Integer customerID);
	List<Reservation> findByRestaurantID(Integer restaurantID);
}
