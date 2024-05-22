// Generates jwt tokens
package com.example.Restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenService {
	 @Autowired
	 private JwtEncoder jwtEncoder;
	 @Autowired
	 private JwtDecoder jwtDecoder;
	 
	  public TokenService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder) {
		this.jwtEncoder = jwtEncoder;
		this.jwtDecoder = jwtDecoder;
	}

	public String generateJwt(Authentication auth){

	      Instant now = Instant.now();

	      String scope = auth.getAuthorities().stream()
	          .map(GrantedAuthority::getAuthority)
	          .collect(Collectors.joining(" "));
	      JwtClaimsSet claims = JwtClaimsSet.builder()
	          .issuer("self")
	          .issuedAt(now)
	          .subject(auth.getName())
	          .claim("roles", scope)
	          .build();

	      return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	    }
	
	public String getUsernameFromToken(String token) {
		Jwt decoded = jwtDecoder.decode(token);
		String username = decoded.getSubject();
		return username;
	}

	public List<String> getRolesFromToken(String token) {
		Jwt decoded = jwtDecoder.decode(token);
		String[] rolesData = decoded.getClaimAsString("roles").split(" ");
		List<String> roles = Arrays.asList(rolesData);
		return roles;
	}
}
