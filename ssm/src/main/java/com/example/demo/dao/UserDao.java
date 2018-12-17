package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

//@Mapper扫描的是main下面的所有文件
@Mapper
@Repository
public interface UserDao {
	User getByName(String name);
	List<User> getAllUser(@Param("begin")int begin,@Param("num")int num);
	int addUser(User user);
	int updateUser(User user);
	int deleteUser(int id);
	int getUserCount();
	User getById(@Param("id")int id);
}
