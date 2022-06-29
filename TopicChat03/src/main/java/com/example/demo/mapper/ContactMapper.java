package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.ContactEntity;
import com.example.demo.form.ContactForm;

/**
 * コンタクトを管理するためのMapper
 * @author jinjinliangjie
 *
 */
@Mapper
public interface ContactMapper {
	/**
	 * コンタクトを追加するための処理
	 * @param contactForm
	 */
	@Insert("insert into contact(user_id, contact_user_id, upddatetime) values(#{user_id}, #{contact_user_id}, NOW())")
	void addContact(ContactForm contactForm);
	
	/**
	 * コンタクトを削除するための処理
	 * @param contactForm
	 */
	@Delete("delete from contact where user_id = #{user_id} AND contact_user_id = #{contact_user_id}")
	void deleteContact(ContactForm contactForm);
	
	/**
	 * コンタクト登録しているユーザーのリストを取得
	 * @param userForm
	 * @return
	 */
	@Select("select contact.user_id, contact.contact_user_id, user.username, user.comment from contact inner join user on contact.user_id = #{user_id} AND contact.contact_user_id = user.user_id")
	List<ContactEntity> getContactUserList(String user_id);
	
	/**
	 * ユーザーIDからユーザー情報を取得する
	 * @param user_id
	 * @return
	 */
	@Select("select user_id, username, comment from user where user_id = #{user_id}")
	public ContactEntity searchUserByUserId(String user_id);
}
