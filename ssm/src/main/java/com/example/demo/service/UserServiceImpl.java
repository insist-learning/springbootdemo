package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userMapper;

	@Override
	public User getByName(String name) {
		return userMapper.getByName(name);
	}

	@Override
	public List<User> getAllUser(int begin, int num) {
		return userMapper.getAllUser(begin, num);
	}

	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return userMapper.deleteUser(id);
	}

	@Override
	public int getUserCount() {
		return userMapper.getUserCount();
	}

	@Override
	public User getById(int id) {
		return userMapper.getById(id);
	}
	
	
} 
