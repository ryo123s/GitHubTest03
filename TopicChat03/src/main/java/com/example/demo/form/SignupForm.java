package com.example.demo.form;

import lombok.Data;

/**
 * 新規登録のためのフォーム
 * @author jinjinliangjie
 *
 */
@Data
public class SignupForm {
	private String user_id;
	private String username;
	private String password;
	private String comment;
}
