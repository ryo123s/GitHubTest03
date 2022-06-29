package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.ChatMemberEntity;
import com.example.demo.entity.ContactEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.form.ChatForm;
import com.example.demo.form.GroupForm;

/**
 * チャットメンバーに関する処理のMapper
 * @author jinjinliangjie
 *
 */
@Mapper
public interface ChatMemberMapper {
	/**
	 * チャットメンバーを追加する処理
	 * @param chatMemberForm
	 */
	@Insert("insert into chat_member(chat_id, user_id, upddatetime) values(#{chat_id}, #{user_id}, NOW())")
	void addChatMember(ChatForm chatForm);
	
	/**
	 * チャットメンバーを削除する処理
	 * @param chatMemberForm
	 */
	@Delete("delete from chat_member where chat_id = #{chat_id} AND user_id = #{user_id}")
	void deleteChatMember(ChatForm chatForm);
	
	/**
	 * ユーザーIDとグループIDからチャットとのリストを取得
	 * @param groupMemberForm
	 * @return
	 */
	@Select("select chat.chat_id, chat.chatname, chat.group_id, chat.comment, chat.upddatetime, chat_member.user_id from chat inner join chat_member on chat.group_id = #{group_id} AND chat.chat_id = chat_member.chat_id AND chat_member.user_id = #{user_id}")
	List<ChatMemberEntity> getChatListByUserIdAndGroupId(GroupForm groupForm);
	
	/**
	 * チャットフォームからチャットのリストを取得
	 * @param chatForm
	 * @return
	 */
	@Select("select chat.chat_id, chat.chatname, chat.group_id, chat.comment, chat.upddatetime, chat_member.user_id from chat inner join chat_member on chat.group_id = #{group_id} AND chat.chat_id = chat_member.chat_id AND chat_member.user_id = #{user_id}")
	List<ChatMemberEntity> getChatListByChatForm(ChatForm chatForm);
	
	/**
	 * チャットに参加しているユーザーのリストを取得
	 * @param chat_id
	 * @return
	 */
	@Select("select chat_member.user_id, user.username from chat_member inner join user on chat_member.chat_id = #{chat_id} AND chat_member.user_id = user.user_id")
	List<UserEntity> getChatMemberListByChatId(String chat_id);
	
	/**
	 * グループ内で指定のチャットに参加していないユーザーのリストを取得
	 * @param chatForm
	 * @return
	 */
	@Select("select group_member.user_id, user.username from group_member inner join user on not exists(select * from chat_member where group_member.user_id = chat_member.user_id AND chat_member.chat_id = #{chat_id}) AND group_member.group_id = #{group_id} AND group_member.user_id = user.user_id")
	List<ContactEntity> getGroupUserListNoChat(ChatForm chatForm);
}
