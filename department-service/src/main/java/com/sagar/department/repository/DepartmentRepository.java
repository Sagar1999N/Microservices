package com.sagar.department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagar.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	Department findByDepartmentId(Long departmentId);
}
