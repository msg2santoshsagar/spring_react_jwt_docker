package com.alife.jwt_server.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@GetMapping("/identity")
	public Map<String, String> identity(Principal principal){
		
		Map<String, String> map = new HashMap<>();
		
		String userName = principal.getName();
		
		map.put("username", userName);
		
		return map;
	}
	
}
