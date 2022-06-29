package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.GroupEntity;
import com.example.demo.form.GroupForm;

/**
 * グループを作成するためのMapper
 * @author jinjinliangjie
 *
 */
@Mapper
public interface GroupMapper {
	/**
	 * グループを作成するための処理
	 * @param GroupForm
	 */
	@Insert("insert into group_table(group_id, groupname, comment, upddatetime) values(#{group_id}, #{groupname}, #{comment}, NOW())")
	void addGroup(GroupForm GroupForm);
	
	/**
	 * グループを検索するための処理
	 * @param groupForm
	 * @return
	 */
	@Select("select group_id, groupname from group_table where group_id = #{group_id};")
	GroupEntity searchGroupByGroupId(GroupForm groupForm);
	
	/**
	 * グループの更新日時を更新するための処理
	 * @param group_id
	 */
	@Update("update group_table set upddatetime = NOW() where group_id = #{group_id};")
	void update(String group_id);
}
