// Controller for Customer related pages
package com.example.Restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant.models.Customer;
import com.example.Restaurant.models.CustomerDTO;
import com.example.Restaurant.services.CustomerService;



@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/{username}/information")
	public Customer getInformation(@PathVariable String username) {
		username = username.replace("\"", "");
		return customerService.getCurrentCustomer(username);
	}
	
	@GetMapping("/{customerID}/details")
	public Customer getCustomerByID(@PathVariable String customerID) {
		customerID = customerID.replace("\"", "");
		return customerService.getCustomerByID(Integer.parseInt(customerID));
	}
	
	@PostMapping("/update-information/{username}")
    public Customer updateInformation(@RequestBody CustomerDTO body, @PathVariable String username) {
		username = username.replace("\"", "");
        return customerService.updateCustomer(username, body.getFirstName(), body.getLastName(), body.getPhoneNumber());
    }

	@GetMapping("/check-exists")
	@ResponseBody
    public boolean checkIfCustomerExists(@RequestParam String username) {
		return customerService.checkIfCustomerExistsByUsername(username);
    }
}
