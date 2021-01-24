package com.github.apz.controller.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.view.UserForm;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/session-sample")
@SessionAttributes("userForm")
@Log4j2
public class SessionScopeController {
	@GetMapping("/")
	public ModelAndView display(ModelAndView mnv, @ModelAttribute UserForm userForm) {
		userForm.initialized();
		mnv.setViewName("session");
		return mnv;
	}

	@PostMapping("confirm")
	public ModelAndView confirm(ModelAndView mnv, @ModelAttribute UserForm userForm) {
		mnv.setViewName("session-confirm");
		return mnv;
	}

	@PostMapping("complete")
	public ModelAndView complete(ModelAndView mnv, @ModelAttribute UserForm userForm) {

		log.info(userForm);
		mnv.setViewName("redirect:/session-sample/");
		return mnv;
	}

	@ModelAttribute
	public UserForm userForm() {
		return new UserForm();
	}
}
