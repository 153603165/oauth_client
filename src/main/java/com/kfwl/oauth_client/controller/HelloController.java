package com.kfwl.oauth_client.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

	@SuppressWarnings("unused")
	@RequestMapping("/hello")
	public String hello() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "Hello World Oauth"+SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@RequestMapping("/hello2")
	@PreAuthorize("hasAnyAuthority('hello2:view')")
	public String hello2() {
		return "Hello World Oauth"+SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	

	@RequestMapping("/hello3")
	@PreAuthorize("hasAnyAuthority('role:view')")	
	public String hello3() {
		return "Hello World Oauth"+SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	

}