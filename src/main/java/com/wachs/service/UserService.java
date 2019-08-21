package com.wachs.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wachs.pojo.User;

public interface UserService {
	public PageInfo<User> queryUsers(Integer pageNum,Integer pageSize);
}
