package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ChatEntity;
import com.example.demo.form.ChatForm;
import com.example.demo.form.GroupForm;
import com.example.demo.mapper.ChatMapper;

/**
 * チャットに関するサービスクラス
 * @author jinjinliangjie
 *
 */
@Service
public class ChatService {
	@Autowired
	private ChatMapper chatMapper;
	
	/**
	 * 新規のチャットを追加するための処理
	 * @param chatForm
	 */
	@Transactional
	public void addChat(ChatForm chatForm) {
		chatMapper.addChat(chatForm);
	}
	
	/**
	 * グループIDからチャットのリストを取得する
	 * @param groupForm
	 * @return
	 */
	@Transactional
	public List<ChatEntity> getChatByGroupId(GroupForm groupForm){
		return chatMapper.getChatByGroupId(groupForm);
	}
	
	/**
	 * チャットの更新日時を更新する処理
	 * @param chat_id
	 */
	@Transactional
	public void update(String chat_id) {
		chatMapper.update(chat_id);
	}
}
