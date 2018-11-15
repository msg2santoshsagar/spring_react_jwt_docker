package com.alife.jwt_server.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationInformationController {

	@GetMapping("/ping")
	public String ping() {
		return "Your Application is up at "+new Date();
	}



}
