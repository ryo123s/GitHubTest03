package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ContactEntity;
import com.example.demo.entity.GroupMemberEntity;
import com.example.demo.form.GroupForm;
import com.example.demo.mapper.GroupMemberMapper;

/**
 * グループメンバーに関するサービスクラス
 * @author jinjinliangjie
 *
 */
@Service
public class GroupMemberService {
	@Autowired
	private GroupMemberMapper groupMemberMapper;
	
	/**
	 * グループにメンバーを追加する
	 * @param groupMemberForm
	 */
	@Transactional
	public void addGroupMember(GroupForm groupForm) {
		groupMemberMapper.addGroupMember(groupForm);
	}
	
	/**
	 * グループ作成時にユーザーをグループのメンバーに追加する
	 * @param groupForm
	 */
	@Transactional
	public void addGroupMemberWhenAddGroup(GroupForm groupForm) {
		groupMemberMapper.addGroupMemberWhenAddGroup(groupForm);
	}
	
	/**
	 * グループのメンバーを削除する
	 * @param groupMemberForm
	 */
	@Transactional
	public void deleteGroupMember(GroupForm groupForm) {
		groupMemberMapper.deleteGroupMember(groupForm);
	}
	
	/**
	 * ユーザーが所属しているグループのリストを取得する
	 * @param userForm
	 * @return
	 */
	@Transactional
	public List<GroupMemberEntity> getGroupListByUserId(String user_id){
		return groupMemberMapper.getGroupListByUserId(user_id);
	}
	
	/**
	 * グループに所属しているユーザーのリストを取得
	 * @param group_id
	 * @return
	 */
	@Transactional
	public List<GroupMemberEntity> getGroupMemberListByGroupId(String group_id){
		return groupMemberMapper.getGroupMemberListByGroupId(group_id);
	}
	
	/**
	 * コンタクトの中でグループに参加していないユーザーのリストを表示
	 * @param groupForm
	 * @return
	 */
	@Transactional
	public List<ContactEntity> getContactListNoGroup(GroupForm groupForm){
		return groupMemberMapper.getContactListNoGroup(groupForm);
	}
}
