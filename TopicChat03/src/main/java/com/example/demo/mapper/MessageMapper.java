package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.MessageEntity;
import com.example.demo.form.MessageForm;

/**
 * メッセージに関するMapper
 * @author jinjinliangjie
 *
 */
@Mapper
public interface MessageMapper {
	/**
	 * メッセージをDBに格納する処理
	 * @param messageForm
	 */
	@Insert("insert into message(text, file, user_id, to_user_id, reply_id, chat_id, upddatetime) values(#{text}, #{file}, #{user_id}, #{to_user_id}, #{reply_id}, #{chat_id}, NOW())")
	void addMessege(MessageForm messageForm);
	
	/**
	 * チャットのメッセージを取得
	 * @param groupMemberForm
	 * @return
	 */
	@Select("select message.id, message.text, message.file, message.user_id, message.to_user_id, message.reply_id, message.chat_id, message.upddatetime, user.username from message inner join user on chat_id = #{chat_id} AND message.user_id = user.user_id")
	List<MessageEntity> getMessageByChatId(String chat_id);
}
