package com.github.apz.controller.radio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/radio")
@RequiredArgsConstructor
public class RadioController {

	private final ProductService service;

	@GetMapping
	public ModelAndView display(ModelAndView mnv) {

		var products = service.findProduct();
		mnv.addObject("products", products);
		mnv.addObject("checkedProduct", 3);
		mnv.setViewName("radio");
		return mnv;
	}
}
