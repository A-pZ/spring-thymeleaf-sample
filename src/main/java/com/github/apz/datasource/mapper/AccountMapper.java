package com.github.apz.datasource.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.github.apz.entity.Account;

@Mapper
public interface AccountMapper {
	@Select("SELECT id, name FROM account;")
	public List<Account> findAll();
}
