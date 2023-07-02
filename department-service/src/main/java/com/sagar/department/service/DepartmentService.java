package com.sagar.department.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sagar.department.VO.ResponseTemplateVO;
import com.sagar.department.VO.User;
import com.sagar.department.entity.Department;
import com.sagar.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private RestTemplate restTemplate;
	
    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

	public List<Department> findDepartment() {
		log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.findAll();
	}

	public ResponseTemplateVO findUsersByDepartment(Long departmentId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Department department = departmentRepository.findByDepartmentId(departmentId);
		vo.setDepartment(department);
		//User[] users = restTemplate.getForObject("http://user-service/users/departments/"+departmentId,(List<User>).class);
		ResponseEntity<User[]> response = restTemplate.getForEntity("http://user-service/users/departments/"+departmentId,
				  User[].class);
		User[] users = response.getBody();
		vo.setUser(Arrays.asList(users));
		return vo;
	}

	public List<ResponseTemplateVO> findUsersWithDepartments() {
		List<Department> departments = departmentRepository.findAll();
		List<ResponseTemplateVO> list = new ArrayList<>();
		for(Department department : departments) {
			ResponseTemplateVO vo = new ResponseTemplateVO();
			vo.setDepartment(department);
			ResponseEntity<User[]> response = restTemplate.getForEntity("http://user-service/users/departments/"+department.getDepartmentId(),
					  User[].class);
			User[] users = response.getBody();
			vo.setUser(Arrays.asList(users));
			list.add(vo);
		}
		return list;
	}
}