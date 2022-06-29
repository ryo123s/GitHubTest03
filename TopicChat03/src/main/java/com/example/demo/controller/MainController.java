package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.form.SignupForm;

/**
 * ログイン前の画面遷移のコントローラー
 * @author jinjinliangjie
 *
 */
@Controller
public class MainController {
	/**
	 * ログイン画面に遷移
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	/**
	 * 新規登録画面に遷移
	 * @param signupForm
	 * @return
	 */
	@GetMapping("/signup")
	public String signup(SignupForm signupForm) {
		return "/signup";
	}
	
	@GetMapping("/index")
	public String index() {
		return "/index";
	}
}
