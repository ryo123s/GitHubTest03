package com.example.demo.form;

import lombok.Data;

/**
 * グループを作成するためのフォーム
 * @author jinjinliangjie
 *
 */
@Data
public class GroupForm {
	private String group_id;
	private String groupname;
	private String comment;
	private String user_id;
	private String contact_user_id;
}
