package com.github.apz.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/listbox")
public class ListboxController {
	@GetMapping
	public ModelAndView display(ModelAndView mnv) {

		mnv.addObject("listbox", createListbox());
		mnv.addObject("month", 8);
		mnv.setViewName("listbox");
		return mnv;
	}

	@PostMapping
	public ModelAndView selected(ModelAndView mnv, @RequestParam Integer month) {

		mnv.addObject("listbox", createListbox());
		mnv.addObject("month", month);
		mnv.setViewName("listbox");
		return mnv;
	}

	List<Integer> createListbox() {
		return IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
	}
}
