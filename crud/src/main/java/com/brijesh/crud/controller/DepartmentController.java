package com.brijesh.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijesh.crud.entity.Department;
import com.brijesh.crud.model.DepartmentModel;
import com.brijesh.crud.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	 
	@PostMapping
	public String addDepartment(@RequestBody DepartmentModel departmentModel) {
	   departmentService.addDepartment(departmentModel);
	   return "Added";
	}
	@GetMapping()
	public List<Department> fetchDepartmentList() {
		return departmentService.fetchDepartmentList();
	}
	@GetMapping("/{id}")
	public Department fetDepartmentById(@PathVariable("id") String departmentId)
	{
		return departmentService.fetchDepartmentById(departmentId);
	}
	@DeleteMapping("/{id}")
	public String deleteDepartmentById(@PathVariable("id") String departmentId)
	{
		 departmentService.deleteDepartmentById(departmentId);
		 return "Department Deleted Successfully";
	} 
	  @PutMapping("/{id}")
	public Department updateDepartmentById(@PathVariable("id") String departmentId,@RequestBody Department department)
	{
		  return departmentService.updateDepartmentById(departmentId,department);
	}
}
