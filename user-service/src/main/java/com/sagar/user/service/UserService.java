package com.sagar.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sagar.user.VO.Department;
import com.sagar.user.VO.ResponseTemplateVO;
import com.sagar.user.entity.User;
import com.sagar.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		log.info("Inside userservice inside saveUser");
		return userRepository.save(user);
	}
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside userservice inside getUserWithDepartment");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		
		Department department = restTemplate.getForObject("http://department-service/departments/"+user.getDepartmentId(),Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
	public List<ResponseTemplateVO> getUsersWithDepartments() {
		List<ResponseTemplateVO> response = new ArrayList<>();
		List<User> users = userRepository.findAll();
		for(User user : users) {
			ResponseTemplateVO vo = new ResponseTemplateVO();
			vo.setUser(user);
			vo.setDepartment(restTemplate.getForObject("http://department-service/departments/"+user.getDepartmentId(),Department.class));
			response.add(vo);
		}
		return response;
	}
	public List<User> getUsersByDepartmentId(Long departmentId) {
		System.out.println("dydo");
		return userRepository.findByDepartmentId(departmentId);
	}

}