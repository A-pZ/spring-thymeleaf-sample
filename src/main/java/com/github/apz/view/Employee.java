package com.github.apz.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Employee {
	private Integer id;
	private String name;
	private String department;

	public static Employee of(Integer id, String name, String department) {
		return new Employee(id, name, department);
	}
}
