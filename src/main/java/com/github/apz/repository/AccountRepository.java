package com.github.apz.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.apz.entity.Account;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AccountRepository {
	private final JdbcTemplate jdbcTemplate;

	public List<Account> findAll() {
		return jdbcTemplate.query("SELECT id, name FROM account",
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	public Account findById(int id) {
		return jdbcTemplate.queryForObject("SELECT id, name FROM account WHERE id=?"
				, new Object[]{id}
				, new BeanPropertyRowMapper<Account>(Account.class));
	}
}
