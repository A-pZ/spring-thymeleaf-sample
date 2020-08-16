package com.github.apz.controller.validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.Getter;
import lombok.Setter;

@Controller
@RequestMapping("/validator")
public class ValidatorController {
	@GetMapping
	public ModelAndView display(ModelAndView mnv, @ModelAttribute("form") UserRegisterForm form) {
		mnv.setViewName("validator");
		return mnv;
	}

	@PostMapping
	public ModelAndView check(@ModelAttribute("form") @Validated UserRegisterForm form, BindingResult result, ModelAndView mnv) {
		if (result.hasErrors()) {
			mnv.setViewName("validator");
			return mnv;
		}

		mnv.setViewName("validator");
		return mnv;
	}

	@Getter @Setter
	public static class UserRegisterForm {
		@NotEmpty
		@Email
		private String email;
		@NotEmpty
		private String name;
	}
}
