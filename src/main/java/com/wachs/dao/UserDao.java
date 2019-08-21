package com.wachs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wachs.pojo.User;

public interface UserDao {
	@Select("select * from user")
	public List<User> queryUsers();
}
