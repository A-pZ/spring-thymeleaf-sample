package com.github.apz.controller.checkbox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.service.ProductService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Controller
@RequestMapping("/checkbox")
@RequiredArgsConstructor
public class CheckboxController {

	private final ProductService service;

	@GetMapping
	public ModelAndView display(ModelAndView mnv) {

		var products = service.findProduct();
		mnv.addObject("products", products);

		List<Integer> checkedProduct = Stream.of(3, 5).collect(Collectors.toList());
		mnv.addObject("checkedProduct", checkedProduct);
		mnv.setViewName("checkbox");
		return mnv;
	}

	@PostMapping
	public ModelAndView checked(ModelAndView mnv, @ModelAttribute CheckForm form) {
		var products = service.findProduct();
		mnv.addObject("products", products);

		List<Integer> checkedProduct = form.getCheckedProduct();
		mnv.addObject("checkedProduct", checkedProduct);
		mnv.setViewName("checkbox");
		return mnv;
	}

	@Getter @Setter
	public static class CheckForm {
		// チェックボックスがすべて空のときには、空のListを返すよう初期化する
		private List<Integer> checkedProduct = new ArrayList<>();
	}
}
