package com.github.apz.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.github.apz.entity.Account;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NamedQueryAccountRepository {
	private final NamedParameterJdbcTemplate template;

	public Account findById(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject("SELECT id, name FROM account WHERE id = :id", param, new BeanPropertyRowMapper<Account>(Account.class));
	}
}
