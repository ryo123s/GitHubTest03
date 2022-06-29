package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * メッセージ情報を格納するためのEntity
 * @author jinjinliangjie
 *
 */
@Data
public class MessageEntity {
	private int id;
	private String text;
	private String file;
	private String user_id;
	private String username;
	private String to_user_id;
	private int relply_id;
	private String chat_id;
	private LocalDateTime upddatetime;
}
