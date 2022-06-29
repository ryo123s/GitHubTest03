package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ChatMemberEntity;
import com.example.demo.entity.ContactEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.form.ChatForm;
import com.example.demo.form.GroupForm;
import com.example.demo.mapper.ChatMemberMapper;

/**
 * チャットメンバーに関するサービスクラス
 * @author jinjinliangjie
 *
 */
@Service
public class ChatMemberService {
	@Autowired
	private ChatMemberMapper chatMemberMapper;
	
	/**
	 * チャットメンバーを追加する処理
	 * @param chatMemberForm
	 */
	@Transactional
	public void addChatMember(ChatForm chatForm) {
		chatMemberMapper.addChatMember(chatForm);
	}
	
	/**
	 * チャットメンバーを削除する処理
	 * @param chatMemberForm
	 */
	@Transactional
	public void deleteChatMember(ChatForm chatForm) {
		chatMemberMapper.deleteChatMember(chatForm);
	}
	
	/**
	 * ユーザーIDとグループIDからチャットのリストを取得
	 * @param groupForm
	 * @return
	 */
	@Transactional
	public List<ChatMemberEntity> getChatListByUserIdAndGroupId(GroupForm groupForm){
		return chatMemberMapper.getChatListByUserIdAndGroupId(groupForm);
	}
	
	@Transactional
	public List<ChatMemberEntity> getChatListByChatForm(ChatForm chatForm){
		return chatMemberMapper.getChatListByChatForm(chatForm);
	}
	
	/**
	 * チャットに参加しているユーザーのリストを取得
	 * @param chat_id
	 * @return
	 */
	@Transactional
	public List<UserEntity> getChatMemberByChatId(String chat_id){
		return chatMemberMapper.getChatMemberListByChatId(chat_id);
	}
	
	/**
	 * グループ内で指定のチャットに入っていないユーザーのリストを取得する
	 * @param chatForm
	 * @return
	 */
	@Transactional
	public List<ContactEntity> getGroupUserListNoChat(ChatForm chatForm){
		return chatMemberMapper.getGroupUserListNoChat(chatForm);
	}
}
