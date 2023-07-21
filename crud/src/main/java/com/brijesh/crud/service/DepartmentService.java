package com.brijesh.crud.service;

import java.util.List;

import com.brijesh.crud.entity.Department;
import com.brijesh.crud.model.DepartmentModel;

public interface DepartmentService {
	
	public Department addDepartment(DepartmentModel departmentModel);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(String departmentId);

	public void deleteDepartmentById(String departmentId);

	public Department updateDepartmentById(String departmentId, Department department);

}
