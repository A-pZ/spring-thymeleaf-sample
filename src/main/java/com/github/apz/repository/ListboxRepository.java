package com.github.apz.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

@Repository("listbox")
public class ListboxRepository {
	public List<Integer> createListbox() {
		return IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
	}
}
