// Service to submit new restaurant data to database
package com.example.Restaurant.services;

import com.example.Restaurant.models.ApplicationUser;
import com.example.Restaurant.models.Restaurant;
import com.example.Restaurant.repository.RestaurantRepository;
import com.example.Restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RestaurantService {

	@Autowired
    private UserRepository userRepository;
 	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Restaurant getCurrentRestaurant(String username) {
		Optional<ApplicationUser> user = userRepository.findByUsername(username);
		ApplicationUser currentUser = user.get();
		Integer restaurantID = currentUser.getcustomerOrRestaurantID();
		Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantID);
		Restaurant currentRestaurant = restaurant.get();
		
		return currentRestaurant;
	}
	
	public Restaurant getRestaurantByName(String restaurantName) {
		return restaurantRepository.findByRestaurantName(restaurantName).get();
	}
	
	public Restaurant getRestaurantByID(Integer restaurantID) {
		return restaurantRepository.findById(restaurantID).get();
	}
	
	//TODO: check restaurant/customer inital object creation logic, could refactor later
	public Restaurant updateRestaurant(String currentUsername, String restaurantName, String address, String phoneNumber, String cuisine, 
									String openingTime, String closingTime){
			
			Restaurant currentRestaurant = getCurrentRestaurant(currentUsername);
			currentRestaurant.setRestaurantName(restaurantName);
			currentRestaurant.setAddress(address);
			currentRestaurant.setPhoneNumber(phoneNumber);
			currentRestaurant.setCuisine(cuisine);
			currentRestaurant.setOpeningTime(openingTime);
			currentRestaurant.setClosingTime(closingTime);
			return restaurantRepository.save(currentRestaurant);
	
	}

	public boolean checkIfRestaurantExistsByUsername(String username) {
		//TODO check when customer object should be created - refactor this
		// instead of checking if the object exists, checks if the name is null
		// because of the restaurant object creation at initial registration.
		
		Restaurant currentRestaurant = getCurrentRestaurant(username);
		return currentRestaurant.getRestaurantName() != null;
	}
	
	// adding pictures method, works but still testing
		public void addPicture(String username, byte[] photo) {
			Restaurant currentRestaurant = getCurrentRestaurant(username);
			currentRestaurant.setPhoto(photo);
			restaurantRepository.save(currentRestaurant);
			
		}
		
		public List<Restaurant> getAllRestaurants() {
			return restaurantRepository.findAll();
		}
		
		public List<Restaurant> filterRestaurantsByName(String searchInput) {
			return restaurantRepository.findAllByRestaurantNameContaining(searchInput);
		}

		public List<Restaurant> filterRestaurantsByCuisine(String cuisineSelection) {
			return restaurantRepository.findAllByRestaurantCuisineContaining(cuisineSelection);
		}

		public List<Restaurant> filterRestaurantsByNameAndCuisine(String searchInput, String cuisineSelection) {
			return restaurantRepository.findAllByRestaurantNameAndCuisineContaining(searchInput, cuisineSelection);
		}
}
