package com.github.apz.controller.pagination;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/pageable")
@RequiredArgsConstructor
public class DomainPageableController {
	private final EmployeeService service;

	@GetMapping
	public ModelAndView display(ModelAndView mnv, @PageableDefault(page = 0, size = 5) Pageable pageable) {

		var employees = service.find(pageable);

		mnv.addObject("employees", employees);
		mnv.addObject("page", pageable);
		mnv.setViewName("pageable");
		return mnv;
	}
}
