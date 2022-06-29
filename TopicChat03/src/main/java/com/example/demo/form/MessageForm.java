package com.example.demo.form;

import lombok.Data;

/**
 * メッセージを送信するためのフォーム
 * @author jinjinliangjie
 *
 */
@Data
public class MessageForm {
	private String text;
	private String file;
	private String user_id;
	private String username;
	private String to_user_id;
	private int reply_id;
	private String chat_id;
	private String chatname;
	private String group_id;
	private String groupname;
}
