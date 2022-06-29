package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.GroupEntity;
import com.example.demo.form.GroupForm;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.mapper.GroupMemberMapper;

/**
 * グループに関するサービスクラス
 * @author jinjinliangjie
 *
 */
@Service
public class GroupService {
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private GroupMemberMapper groupMemberMapper;
	
	/**
	 * グループを追加するための処理
	 * @param groupForm
	 */
	@Transactional
	public void addGroup(GroupForm groupForm) {
		groupMapper.addGroup(groupForm);
		groupMemberMapper.addGroupMemberWhenAddGroup(groupForm);
	}
	
	/**
	 * グループIDからグループ情報を取得する処理
	 * @param groupForm
	 * @return
	 */
	@Transactional
	public GroupEntity searchGroupByGroupId(GroupForm groupForm) {
		return groupMapper.searchGroupByGroupId(groupForm);
	}
	
	/**
	 * グループの更新日時を更新するための処理
	 * @param group_id
	 */
	@Transactional
	public void update(String group_id) {
		groupMapper.update(group_id);
	}
}
