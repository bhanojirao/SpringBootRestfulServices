package com.myapp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.Employee;
import com.myapp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmp(@RequestBody Employee emp) {
		logger.debug("EmployeeController in side addEmployee method Request is:" + emp);
		String result = employeeService.addEmployee(emp);
		logger.info("EmployeeController exit addEmployee method Ressponse is:" + result);
		return result;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public Optional<Employee> getEmp(@RequestBody Employee emp) {
		return employeeService.getEmployee(emp.getId());
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/xml", consumes = "application/json")
	public List<Employee> getAllEmp() {
		List<Employee> list = employeeService.getAllEmployee();
		return list;
	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	@Procedure("application/json")
	public String getEmp(@RequestParam int id) {
		String status;
		try {
			employeeService.deleteEmployee(id);
			status = "record deleted successfully:" + id;
		} catch (Exception e) {
			status = e.getMessage();

		}
		return status;

	}

	@RequestMapping(value = "/checkEmp", method = RequestMethod.GET)
	public String chekEmployee(@RequestParam int id) {
		String status = "";
		boolean result = employeeService.checkEmployee(id);
		if (result) {
			status = "employee record avilable";
		} else {
			status = "employee not exist";

		}
		return status;
	}

}
