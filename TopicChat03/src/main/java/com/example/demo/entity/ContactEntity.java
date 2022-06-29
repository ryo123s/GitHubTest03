package com.example.demo.entity;

import lombok.Data;

/**
 * コンタクト情報を格納するためのEntity
 * @author jinjinliangjie
 *
 */
@Data
public class ContactEntity {
	private String user_id;
	private String contact_user_id;
	private String username;
	private String comment;
	private String group_id;
}
