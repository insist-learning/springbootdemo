package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.User;

public interface UserService {
	public User getByName(String name);
	public List<User> getAllUser(int begin,int num);
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);
	public int getUserCount();
	public User getById(int id);
}
