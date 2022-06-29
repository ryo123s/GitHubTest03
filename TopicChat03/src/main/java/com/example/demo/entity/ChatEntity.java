package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * チャット情報を格納するためのEntity
 * @author jinjinliangjie
 *
 */
@Data
public class ChatEntity {
	private String chat_id;
	private String chatname;
	private String group_id;
	private String comment;
	private LocalDateTime upddatetime;
}
