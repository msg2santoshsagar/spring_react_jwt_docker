package com.alife.jwt_server.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationInformationController {

	@GetMapping("/ping")
	public Map<String, String> ping() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "Your Application is up at "+new Date());
		return map;
	}



}
