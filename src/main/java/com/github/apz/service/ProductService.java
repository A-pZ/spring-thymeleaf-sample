package com.github.apz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.apz.view.Product;

@Service
public class ProductService {
	public Map<Integer, String> findProductMap() {
		Map<Integer, String> map = new HashMap<Integer, String>() {{
			put(1, "製品A");
			put(2, "製品B");
			put(3, "製品C");
		}};

		return map;
	}

	public List<Product> findProduct() {
		List<Product> products = new ArrayList<Product>() {{
			add(Product.of(1, "製品A"));
			add(Product.of(2, "製品B"));
			add(Product.of(3, "製品C"));
			add(Product.of(4, "製品D"));
			add(Product.of(5, "製品E"));
		}};

		return products;
	}
}
