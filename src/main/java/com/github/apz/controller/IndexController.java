/**
 *
 */
package com.github.apz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author a-pz
 *
 */
@RequestMapping("/")
@Controller
public class IndexController {

	@GetMapping
	public ModelAndView display(ModelAndView mnv) {

		mnv.setViewName("index");
		return mnv;
	}
}
