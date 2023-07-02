package com.sagar.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.department.VO.ResponseTemplateVO;
import com.sagar.department.VO.User;
import com.sagar.department.entity.Department;
import com.sagar.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService service;
	
    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
    	System.out.println(department);
        log.info("Inside saveDepartment method of DepartmentController");
        return  service.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return service.findDepartmentById(departmentId);
    }
    
    @GetMapping("/")
    public List<Department> findDepartment() {
        log.info("Inside findDepartmentById method of DepartmentController");
        return service.findDepartment();
    }

    @GetMapping("/users/{departmentId}")
    public ResponseTemplateVO findUsersByDepartment(@PathVariable ("departmentId") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return service.findUsersByDepartment(departmentId);
    }
    
    @GetMapping("/users")
    public List<ResponseTemplateVO> findUsersWithDepartments() {
        log.info("Inside findDepartmentById method of DepartmentController");
        return service.findUsersWithDepartments();
    }
}