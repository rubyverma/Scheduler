package com.scheduler.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.UserMapper;
import com.scheduler.models.Client;
import com.scheduler.models.OfficialUser;
import com.scheduler.models.User;

@Component
public class UserService {
	
    @Autowired(required = true)
    private UserMapper userMapper;
    	
	public User findUserById(@Param("id") int id )  throws BadSqlGrammarException {
		return userMapper.findUserById(id);
	}

	public List<User> searchUserByEmail(@Param("email") String email )  throws BadSqlGrammarException {
		List<User> users = new ArrayList<User>();

		users = userMapper.searchUserByEmail(email);
		
		return users;
	}
	
	public  int saveUser(User u)  throws BadSqlGrammarException {
		return userMapper.saveUser(u);
	}
	
	public List<User> findAllUsers() throws BadSqlGrammarException  {
		
		return userMapper.findAllUsers();
	}
	
	public int deleteUser(@Param("id") int id)  throws BadSqlGrammarException {
		return userMapper.deleteUser(id);
	}

	public String getNickName(int user_id) {
		return "Nickname of " + user_id;
	}
   
}
