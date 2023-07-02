package com.sagar.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.user.VO.ResponseTemplateVO;
import com.sagar.user.entity.User;
import com.sagar.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside user Controller inside saveUser");
		return service.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Inside user Controller inside getUserWithDepartment");
		return service.getUserWithDepartment(userId);
	}
	
	@GetMapping("/")
	public List<ResponseTemplateVO> getUsersWithDepartments() {
		log.info("Inside user Controller inside getUserWithDepartment");
		return service.getUsersWithDepartments();
	}
	
	@GetMapping("/departments/{departmentId}")
	public List<User> getUsersByDepartmentId(@PathVariable("departmentId") Long departmentId) {
		System.out.println("dydo");
		log.info("Inside user Controller inside getUserbyDepartmentid");
		return service.getUsersByDepartmentId(departmentId);
	}
}