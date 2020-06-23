package com.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.model.Employee;
import com.myapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired 
	private EmployeeRepository repo;
	
	public String addEmployee(Employee emp) {
		String status="Record  not inserted successfully..!";
		Employee e=repo.save(emp);
		if(e!=null) {
			status="Record inserted successfully...!";
		}
	return status;
	}
	
	public Optional<Employee> getEmployee(int id) {
		Optional<Employee> emp = repo.findById(id);
		return emp;
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) repo.findAll();
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);;
	}

	public boolean checkEmployee(int id) {
		// TODO Auto-generated method stub
		boolean result=repo.existsById(id);
		return result;
	}
}
