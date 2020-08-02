package com.github.apz.controller.table;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/table")
@RequiredArgsConstructor
public class TableController {

	private final EmployeeService service;

	@GetMapping
	public ModelAndView display(ModelAndView mnv) {

		var employees = service.findAll();
		mnv.addObject("employees", employees);
		mnv.setViewName("table");
		return mnv;
	}
}
