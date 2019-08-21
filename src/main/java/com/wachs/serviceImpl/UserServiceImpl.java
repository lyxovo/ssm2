package com.wachs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wachs.dao.UserDao;
import com.wachs.pojo.User;
import com.wachs.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;
	@Override
	public PageInfo<User> queryUsers(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize,"uid desc");
		List<User> users = userdao.queryUsers();
		PageInfo<User> pageInfo=new PageInfo<User>(users,8);
//		PageInfo<User> pageInfo=new PageInfo<User>(users);
		return pageInfo;
	}

}
