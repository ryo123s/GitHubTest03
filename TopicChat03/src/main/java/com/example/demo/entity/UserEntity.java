package com.example.demo.entity;

import lombok.Data;

/**
 * ユーザー情報を格納するためのEntity
 * @author jinjinliangjie
 *
 */
@Data
public class UserEntity {
	private String user_id;
	private String username;
	private String comment;
}
