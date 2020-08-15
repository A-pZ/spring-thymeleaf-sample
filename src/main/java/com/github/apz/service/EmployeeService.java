package com.github.apz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.apz.view.Employee;

@Service
public class EmployeeService {
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>() {{
			add( Employee.of(1, "従業員Aさん", "営業部"));
			add( Employee.of(2, "従業員Bさん", "営業部"));
			add( Employee.of(3, "従業員Cさん", "製造部"));
			add( Employee.of(4, "従業員Dさん", "製造部"));
			add( Employee.of(5, "従業員Eさん", "製造部"));
			add( Employee.of(6, "従業員Fさん", "販売部"));
			add( Employee.of(7, "従業員Gさん", "販売部"));
			add( Employee.of(8, "従業員Hさん", "総務部"));
			add( Employee.of(9, "従業員Iさん", "人事部"));
			add( Employee.of(10, "従業員Jさん", "経営部"));
			add( Employee.of(11, "従業員Kさん", "経営部"));
		}};

		return employees;
	}

	public List<Employee> find(Pageable pageable) {
		int pageNumber = pageable.getPageNumber();
		int pageSize = pageable.getPageSize();

		int start = pageNumber * pageSize;
		int end = (pageNumber +1 ) * pageSize;

		List<Employee> employees = findAll()
				.stream()
					.filter(employee -> employee.getId() >= start)
					.filter(employee -> employee.getId() < end)
					.collect(Collectors.toList());

		return employees;
	}
}
