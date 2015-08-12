package de.mischok.exploration.springboot.application;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service {
	
	@Autowired
	AccessLogRepository repository;
	
	@RequestMapping("/")
	public String index() {
		this.repository.save(new AccessLog(new Date()));
		
		return "Hello world! Accessed " + this.repository.count() + " times!";
	}
}
