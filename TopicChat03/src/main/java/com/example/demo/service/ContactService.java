package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ContactEntity;
import com.example.demo.form.ContactForm;
import com.example.demo.mapper.ContactMapper;

/**
 * コンタクトに関するサービスクラス
 * @author jinjinliangjie
 *
 */
@Service
public class ContactService {
	@Autowired
	private ContactMapper contactMapper;
	
	/**
	 * コンタクトを追加する処理
	 * @param contactForm
	 */
	@Transactional
	public void addContact(ContactForm contactForm) {
		contactMapper.addContact(contactForm);
	}
	
	/**
	 * コンタクトを削除する処理
	 * @param contactForm
	 */
	@Transactional
	public void deleteContact(ContactForm contactForm) {
		contactMapper.deleteContact(contactForm);
	}
	
	/**
	 * コンタクト登録しているユーザーのリストを取得
	 * @param userForm
	 * @return
	 */
	@Transactional
	public List<ContactEntity> getContactUserList(String user_id){
		return contactMapper.getContactUserList(user_id);
	}
	
	/**
	 * ユーザーIDからユーザのの情報を取得する
	 * @param user_id
	 * @return
	 */
	@Transactional
	public ContactEntity searchUserByUserId(String user_id) {
		return contactMapper.searchUserByUserId(user_id);
	}
}
