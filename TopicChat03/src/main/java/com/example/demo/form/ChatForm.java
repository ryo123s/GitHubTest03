package com.example.demo.form;

import lombok.Data;

/**
 * チャットを作成するためのフォーム
 * @author jinjinliangjie
 *
 */
@Data
public class ChatForm {
	private String chat_id;
	private String chatname;
	private String group_id;
	private String groupname;
	private String comment;
	private String user_id;
}
