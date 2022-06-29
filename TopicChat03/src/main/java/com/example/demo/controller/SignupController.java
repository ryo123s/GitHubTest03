package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;

/**
 * 新規登録をするためのコントローラー
 * @author jinjinliangjie
 *
 */
@Controller
public class SignupController {
	@Autowired
	private SignupService signupService;
	@PostMapping("/signup")
	public String post(@ModelAttribute("signupForm")SignupForm signupForm) {
		try{
			String checkUser = signupService.userCheck(signupForm);
			if(checkUser == null) {
				signupService.signup(signupForm);
				return "login";
			}
			return "signup";
		}catch(Exception e) {
			return "signup";
		}
	}
}
