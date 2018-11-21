package com.alife.jwt_server.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alife.jwt_server.domain.ApplicationUser;
import com.alife.jwt_server.security.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@RestController
@RequestMapping("/api")
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> login(@RequestBody ApplicationUser appUser){
		Map<String, String> resultMap = new HashMap<>();

		if(!appUser.getUsername().equals(appUser.getPassword())) {
			resultMap.put("status", "failed");
			resultMap.put("reason", "username or password is wrong");
			return ResponseEntity.ok(resultMap);
		}

		resultMap.put("status", "success");

		String token = JWT.create()
				.withSubject(appUser.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));


		HttpHeaders headers = new HttpHeaders();
		headers.add(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);

		return ResponseEntity.ok().headers(headers).body(resultMap);
	}


}
