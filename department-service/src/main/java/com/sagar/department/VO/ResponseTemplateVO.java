package com.sagar.department.VO;

import java.util.List;

import com.sagar.department.entity.Department;

public class ResponseTemplateVO {
	
	private List<User> users;
	private Department department;
	public ResponseTemplateVO(List<User> users, Department department) {
		super();
		this.users = users;
		this.department = department;
	}
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseTemplateVO [users=" + users + ", department=" + department + "]";
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUser(List<User> users) {
		this.users = users;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
