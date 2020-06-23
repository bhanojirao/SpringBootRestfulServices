package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.model.Department;
import com.myapp.service.DepartmentService;

@RestController
@RequestMapping("/dept/")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	@RequestMapping(value = "/add",method =RequestMethod.POST)
	public String addDept(@RequestBody Department dept) {
		deptService.addDepartment(dept);
		return "Record inserted Successfully...!";
		
	}
	@RequestMapping(value = "/remove",method =RequestMethod.POST)
	public String removeDept(@RequestBody Department dept) {
		deptService.removeDept(dept.getDeptId());
		return "Record remove Successfully...!";
		
	}
	@RequestMapping(value = "/removeDept",method =RequestMethod.POST)
	public String removeDeptByName(@RequestParam int deptId) {
		deptService.removeDeptByName(deptId);
		return "Record remove Successfully...!";
		
	}
}
