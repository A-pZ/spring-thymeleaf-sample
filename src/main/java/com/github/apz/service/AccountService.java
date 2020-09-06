package com.github.apz.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.github.apz.entity.Account;
import com.github.apz.repository.AccountRepository;
import com.github.apz.repository.NamedQueryAccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository repository;
	private final NamedQueryAccountRepository namedRepository;

	public List<Account> search(Integer id) {
		if (Objects.isNull(id)) {
			return repository.findAll();
		}

		return Arrays.asList(namedRepository.findById(id));
	}
}
