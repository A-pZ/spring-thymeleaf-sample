package com.github.apz.service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.github.apz.entity.Account;
import com.github.apz.repository.AccountRepository;
import com.github.apz.repository.NamedQueryAccountRepository;

@SpringBootTest
@TestPropertySource(locations = "/test.yml")
public class AccountServiceTest {

	@MockBean
	AccountRepository repository;

	@MockBean
	NamedQueryAccountRepository namedRepository;

	@Autowired
	AccountService accountService;

	@Test
	public void test引数なし() {
		doAnswer(invocation -> new ArrayList<Account>()).when(repository).findAll();
		doAnswer(invocation -> new Account()).when(namedRepository).findById(any());

		accountService.search(null);

		verify(repository, description("引数なしが呼び出された")).findAll();
		verify(namedRepository, never().description("引数ありは呼び出されなかった")).findById(any());
	}

	@Test
	public void test引数あり() {
		doAnswer(invocation -> new ArrayList<Account>()).when(repository).findAll();
		doAnswer(invocation -> new Account()).when(namedRepository).findById(any());

		accountService.search(1);

		verify(repository, never().description("引数なしは呼ばれなかった")).findAll();
		verify(namedRepository, description("引数ありは呼ばれた")).findById(any());

	}
}
