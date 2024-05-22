// Service to submit new customer data to database
package com.example.Restaurant.services;

import com.example.Restaurant.models.ApplicationUser;
import com.example.Restaurant.models.Customer;
import com.example.Restaurant.repository.CustomerRepository;
import com.example.Restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer updateCustomer(String username, String firstName, String lastName, String phoneNumber){
		
			Customer updatedCustomer = getCurrentCustomer(username);
			updatedCustomer.setFirstName(firstName);
			updatedCustomer.setLastName(lastName);
			updatedCustomer.setPhoneNumber(phoneNumber);
			return customerRepository.save(updatedCustomer);
	
	}

	public Customer getCurrentCustomer(String username) {
		Optional<ApplicationUser> user = userRepository.findByUsername(username);
		ApplicationUser currentUser = user.get();
		Integer customerID = currentUser.getcustomerOrRestaurantID();
		Optional<Customer> customer = customerRepository.findById(customerID);
		Customer currentCustomer = customer.get();
		
		return currentCustomer;
	}
	
	public Customer getCustomerByID(Integer customerID) {
		return customerRepository.findById(customerID).get();
	}
	
	public boolean checkIfCustomerExistsByUsername(String username) {
		//TODO check when customer object should be created - refactor this
		Customer currentCustomer = getCurrentCustomer(username);
		return currentCustomer.getFirstName() != null;
	}
}
