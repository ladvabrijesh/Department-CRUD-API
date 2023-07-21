package com.brijesh.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
