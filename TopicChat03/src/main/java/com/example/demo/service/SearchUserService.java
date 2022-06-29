package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.UserForm;
import com.example.demo.mapper.SearchUserMapper;

/**
 * ユーザーを検索するためのMapper
 * @author jinjinliangjie
 *
 */
@Service
public class SearchUserService {
	@Autowired
	private SearchUserMapper searchUserMapper;
	@Transactional
	UserEntity searchUserByUserId(UserForm userForm) {
		return searchUserMapper.searchUserByUserId(userForm);
	}
}
