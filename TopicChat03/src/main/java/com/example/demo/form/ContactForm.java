package com.example.demo.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * コンタクトを管理するためのフォーム
 * @author jinjinliangjie
 *
 */
@Data
public class ContactForm {
	private String user_id;
	@NotBlank(message = "ユーザーIDを入力してください")
	private String contact_user_id;
	private String username;
	private String comment;
}
