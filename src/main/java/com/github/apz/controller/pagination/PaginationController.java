package com.github.apz.controller.pagination;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.service.EmployeeService;
import com.github.apz.view.Employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Controller
@RequestMapping("/pagination")
@RequiredArgsConstructor
public class PaginationController {

	private final EmployeeService service;

	@GetMapping
	public ModelAndView display(ModelAndView mnv, @ModelAttribute Page page) {

		var employees = service.findAll();

		PagedListHolder<Employee> pager = new PagedListHolder<>(employees);

		pager.setPage(page.getPageNumber());
		pager.setPageSize(5);
		var pagedList = pager.getPageList();

		mnv.addObject("employees", pagedList);
		mnv.addObject("pager", pager);
		mnv.addObject("page", page);
		mnv.setViewName("pagination");
		return mnv;
	}

	@Getter @Setter
	public static class Page {
		private Integer pageNumber = 0;
	}
}
