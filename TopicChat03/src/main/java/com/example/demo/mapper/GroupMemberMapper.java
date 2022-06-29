package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.ContactEntity;
import com.example.demo.entity.GroupMemberEntity;
import com.example.demo.form.GroupForm;

/**
 * グループメンバーを扱うMapper
 * @author jinjinliangjie
 *
 */
@Mapper
public interface GroupMemberMapper {
	/**
	 * グループメンバーを追加する処理
	 * @param groupMemberForm
	 */
	@Insert("insert into group_member(group_id, user_id, upddatetime) values(#{group_id}, #{contact_user_id}, NOW())")
	public void addGroupMember(GroupForm groupForm);
	
	/**
	 * グループメンバーを追加する処理
	 * @param groupMemberForm
	 */
	@Insert("insert into group_member(group_id, user_id, upddatetime) values(#{group_id}, #{user_id}, NOW())")
	public void addGroupMemberWhenAddGroup(GroupForm groupForm);
	
	/**
	 * グループメンバーを削除する処理
	 * @param chatMemberForm
	 */
	@Delete("delete from group_member where group_id = #{group_id} AND user_id = #{user_id}")
	public void deleteGroupMember(GroupForm groupForm);
	
	/**
	 * ユーザーが所属しているグループのリストを取得する
	 * @param userform
	 * @return
	 */
	@Select("select group_member.group_id, group_member.user_id, group_table.groupname, group_table.comment, group_table.upddatetime from group_member inner join group_table on group_member.user_id = #{user_id} AND group_member.group_id = group_table.group_id")
	List<GroupMemberEntity> getGroupListByUserId(String user_id);
	
	/**
	 * グループに所属しているユーザーのリストを取得
	 * @param group_id
	 * @return
	 */
	@Select("select group_member.user_id, user.username from group_member inner join user on group_member.group_id = #{group_id} AND group_member.user_id = user.user_id")
	List<GroupMemberEntity> getGroupMemberListByGroupId(String group_id);
	
	/**
	 * コンタクトの中でグループに参加していないユーザーのリストを表示
	 * @param groupForm
	 * @return
	 */
	@Select("select contact.contact_user_id, user.username, contact.user_id from contact inner join user on not exists(select * from group_member where contact.contact_user_id = group_member.user_id AND group_member.group_id = #{group_id}) AND contact.user_id = #{user_id} AND contact.contact_user_id = user.user_id")
	List<ContactEntity> getContactListNoGroup(GroupForm groupForm);
}
