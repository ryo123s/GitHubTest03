package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.form.SignupForm;

/**
 * 新規登録用のMapper
 * @author jinjinliangjie
 *
 */
@Mapper
public interface SignupMapper {
	/**
	 * ユーザーIDの登録が既にあるかを確認
	 * @param signupForm
	 * @return
	 */
	@Select("select user_id from user where user_id = #{user_id}")
	String userCheck(SignupForm signupForm);
	
	/**
	 * 新規登録処理のためのフォーム
	 * @param signupForm
	 */
	@Insert("insert into user(user_id, username, password, comment, upddate) values(#{user_id}, #{username}, #{password}, #{comment}, NOW())")
	void signup(SignupForm signupForm);
}
