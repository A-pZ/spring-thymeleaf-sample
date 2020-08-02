/**
 *
 */
package com.github.apz.controller.listbox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.apz.service.ProductService;

import lombok.RequiredArgsConstructor;

/**
 * @author a-pz
 *
 */
@Controller
@RequestMapping("/listboxWithMap")
@RequiredArgsConstructor
public class ListboxWithMapController {

	private final ProductService service;

	@GetMapping
	public ModelAndView display(ModelAndView mnv) {

		var productMap = service.findProductMap();

		mnv.addObject("productMap", productMap);
		mnv.setViewName("listboxWithMap");
		return mnv;
	}


}
