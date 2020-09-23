package com.github.apz.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.apz.datasource.mapper.AccountMapper;
import com.github.apz.entity.Account;

@MybatisTest
class AccountRepositoryTest {

	@Autowired
	AccountMapper mapper;

	@Test
	void test() {
		List<Account> actual = mapper.findAll();

		assertEquals(5, actual.size());

	}

}
