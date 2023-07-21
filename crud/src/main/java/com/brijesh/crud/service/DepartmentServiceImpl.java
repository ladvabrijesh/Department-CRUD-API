package com.brijesh.crud.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.brijesh.crud.entity.Department;
import com.brijesh.crud.model.DepartmentModel;
import com.brijesh.crud.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	
	public Department addDepartment(DepartmentModel departmentModel) {
		
		Department department = Department.builder()
				.departmentId(UUID.randomUUID().toString())
				.departmentName(departmentModel.getDepartmentName())
				.departmentAddress(departmentModel.getDepartmentAddress())
				.departmentCode(departmentModel.getDepartmentCode())
				.build();
		
		departmentRepository.save(department);
		
		return department;
	}

    
	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		//Department fetchDepartment = Department.findAll();
		return departmentRepository.findAll();
	}
	@Override
	public Department fetchDepartmentById(String departmentId) {
		return departmentRepository.findById(departmentId).get();
		
	}
	@Override
	public void deleteDepartmentById(String departmentId)
	{
		departmentRepository.deleteById(departmentId);
	}


	@Override
	public Department updateDepartmentById(String departmentId, Department department) {
		// TODO Auto-generated method stub
		Department Depdb = departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			Depdb.setDepartmentName(department.getDepartmentName());
			
		}
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			Depdb.setDepartmentAddress(department.getDepartmentAddress());
			
		}
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			Depdb.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(Depdb);
	}
	

}
