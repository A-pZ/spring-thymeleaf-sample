package com.github.apz.repository.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.apz.datasource.mapper.AccountMapper;
import com.github.apz.entity.Account;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AccountMybatisRepository {
	private final AccountMapper mapper;

	public List<Account> findAll() {
		return mapper.findAll();
	}
}
