package com.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.model.Department;
import com.myapp.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repo;
	
	public void addDepartment(Department dept) {
		// TODO Auto-generated method stub
		repo.save(dept);
		
	}

	public void removeDept(int deptId) {
		// TODO Auto-generated method stub
		repo.deleteById(deptId);
	}

	public void removeDeptByName(int deptName) {
		// TODO Auto-generated method stub
		repo.deleteById(deptName);
		
	}

}
