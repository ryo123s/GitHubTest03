package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.form.SignupForm;
import com.example.demo.mapper.SignupMapper;

/**
 * 新規登録のためのサービスクラス
 * @author jinjinliangjie
 *
 */
@Service
public class SignupService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private SignupMapper signupMapper;
	
	/**
	 * 既に登録があるかを確認するための処理
	 * @param signupForm
	 * @return
	 */
	@Transactional
	public String userCheck(SignupForm signupForm) {
		return signupMapper.userCheck(signupForm);
	}
	
	/**
	 * 新規登録処理
	 * @param signupForm
	 */
	@Transactional
	public void signup(SignupForm signupForm) {
		String password = passwordEncoder.encode(signupForm.getPassword());
		signupForm.setPassword(password);
		signupMapper.signup(signupForm);
	}
}
