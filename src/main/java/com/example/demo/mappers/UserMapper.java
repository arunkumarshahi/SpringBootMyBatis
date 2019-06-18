package com.example.demo.mappers;

import java.util.List;

import com.example.demo.dao.User;

public interface UserMapper {
	void insertUser(User user);
    User findUserById(Integer id);
    List<User> findAllUsers();
}
