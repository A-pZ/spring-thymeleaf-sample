package com.github.apz.controller.jdbctemplate;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.entity.Account;
import com.github.apz.service.AccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/jdbc-template")
@RequiredArgsConstructor
public class JdbcTemplateController {

	private final AccountService service;

	@GetMapping
	public ModelAndView display(ModelAndView mnv, @RequestParam(name = "id", required = false) Integer id) {

		List<Account> accounts = service.search(id);
		mnv.addObject("accounts", accounts);
		mnv.setViewName("account");
		return mnv;
	}

}
