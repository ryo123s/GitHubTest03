package com.example.demo.form;

import lombok.Data;

/**
 * ユーザー情報を格納するためのフォーム
 * @author jinjinliangjie
 *
 */
@Data
public class UserForm {
	private String user_id;
	private String username;
	private String commnet;
}
