package com.github.apz.controller.validator;

import java.util.ArrayList;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Getter;
import lombok.Setter;

@Controller
@RequestMapping("/validator")
public class ValidatorController {
	@GetMapping
	public ModelAndView display(ModelAndView mnv, @ModelAttribute("form") UserRegisterForm form, @ModelAttribute("errors") ArrayList<FieldError> errors) {
		mnv.setViewName("validator");
		return mnv;
	}

	@PostMapping
	public ModelAndView check(@ModelAttribute("form") @Validated UserRegisterForm form, BindingResult result, ModelAndView mnv, RedirectAttributes flash) {
		if (result.hasErrors()) {
			var errors = result.getFieldErrors();
			flash.addFlashAttribute("errors", errors);
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
