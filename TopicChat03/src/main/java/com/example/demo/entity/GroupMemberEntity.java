package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * グループメンバー情報を格納するためのEntity
 * @author jinjinliangjie
 *
 */
@Data
public class GroupMemberEntity {
	private String group_id;
	private String groupname;
	private String comment;
	private LocalDateTime upddatetime;
	private String user_id;
	private String username;
}
