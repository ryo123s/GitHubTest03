package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.UserForm;

/**
 * ユーザーを検索するためのMappwe
 * @author jinjinliangjie
 *
 */
@Mapper
public interface SearchUserMapper {
	/**
	 * ユーザーIDからユーザーを探す
	 * @param userForm
	 * @return
	 */
	@Select("select user_id, username, comment from user where user_id = #{user_id}")
	public UserEntity searchUserByUserId(UserForm userForm);
}
