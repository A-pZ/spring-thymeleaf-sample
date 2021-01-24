package com.github.apz.controller.validator;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public ModelAndView check(@ModelAttribute("form") @Valid UserRegisterForm form, BindingResult result, ModelAndView mnv) {
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
		@Max(99)
		@Min(10)
		@NotNull
		private Integer age;
	}
}
