package com.omfys.bsat.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
	private List<Employee> employees = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "EmployeeList [employees=" + employees + "]";
	}
	

}
