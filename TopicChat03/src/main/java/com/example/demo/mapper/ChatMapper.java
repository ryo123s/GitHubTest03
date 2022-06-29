package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.ChatEntity;
import com.example.demo.form.ChatForm;
import com.example.demo.form.GroupForm;

/**
 * チャットに関するMapper
 * @author jinjinliangjie
 *
 */
@Mapper
public interface ChatMapper {
	/**
	 * チャットを作成する処理
	 * @param chatForm
	 */
	@Insert("insert into chat(chat_id, chatname, group_id, comment, upddatetime) values(#{chat_id}, #{chatname}, #{group_id}, #{comment}, NOW())")
	public void addChat(ChatForm chatForm);
	
	/**
	 * グループIDからチャットのリストを取得
	 * @param groupForm
	 * @return
	 */
	@Select("select chat_id, chatname, group_id, comment, upddatetime from chat where group_id = #{group_id}")
	public List<ChatEntity> getChatByGroupId(GroupForm groupForm);
	
	/**
	 * チャットの更新日時の更新処理
	 * @param chat_id
	 */
	@Update("update chat set upddatetime = NOW() where chat_id = #{chat_id};")
	void update(String chat_id);
}
