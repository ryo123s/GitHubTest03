package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * チャットメンバー情報を格納するためのEntity
 * @author jinjinliangjie
 *
 */
@Data
public class ChatMemberEntity {
	private String chat_id;
	private String chatname;
	private String comment;
	private String group_id;
	private LocalDateTime upddatetime;
	private String user_id;
}
