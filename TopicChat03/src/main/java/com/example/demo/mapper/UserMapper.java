package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.security.User;

/**
 * ユーザー名からユーザー情報を取得するためのMapper
 * @author jinjinliangjie
 *
 */
@Mapper
public interface UserMapper {
	@Select("select user_id, username, password from user where user_id = #{user_id}")
	public User findByUsername(String user_id);
}
