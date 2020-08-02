package com.github.apz.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @ToString
public class Product {
	private Integer id;
	private String label;

	public static Product of(Integer id, String label) {
		return new Product(id, label);
	}
}
