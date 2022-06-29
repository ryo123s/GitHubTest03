package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.MessageEntity;
import com.example.demo.form.MessageForm;
import com.example.demo.mapper.MessageMapper;

/**
 * メッセージに関するサービスクラス
 * @author jinjinliangjie
 *
 */
@Service
public class MessageService {
	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private GroupService groupService;
	@Autowired
	private ChatService chatService;
	
	/**
	 * メッセージをDBに格納するための処理
	 * @param messageForm
	 */
	@Transactional
	public void addMessage(MessageForm messageForm) {
		messageMapper.addMessege(messageForm);
		groupService.update(messageForm.getGroup_id());
		chatService.update(messageForm.getChat_id());
	}
	
	/**
	 * チャットのメッセージを所得
	 * @param groupMemberForm
	 * @return
	 */
	@Transactional
	public List<MessageEntity> getMessageByChatId(String chat_id){
		return messageMapper.getMessageByChatId(chat_id);
	}
}
