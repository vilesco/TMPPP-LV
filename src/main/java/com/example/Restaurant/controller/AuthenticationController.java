// Controller for register and login
package com.example.Restaurant.controller;

import com.example.Restaurant.models.ApplicationUser;
import com.example.Restaurant.models.LoginResponseDTO;
import com.example.Restaurant.models.RegistrationDTO;
import com.example.Restaurant.repository.UserRepository;
import com.example.Restaurant.services.AuthenticationService;
import com.example.Restaurant.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private TokenService tokenService;

	@PostMapping("/register")
    public ApplicationUser registerUser(RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getEmail(), body.getPassword(), body.getAccountType());
    }
 
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
    	
    @GetMapping("/check-roles")
    public ResponseEntity<List<String>> getMethodName(@RequestParam String token) {
        List<String> roles = tokenService.getRolesFromToken(token);
        return ResponseEntity.ok(roles);
    }
}
