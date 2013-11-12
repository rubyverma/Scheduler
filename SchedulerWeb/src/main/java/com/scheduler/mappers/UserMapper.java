package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.Client;
import com.scheduler.models.OfficialUser;
import com.scheduler.models.User;

@Repository(value="userMapper")
@Component
public interface UserMapper {
	
	User findUserById(@Param("id") int id )  throws BadSqlGrammarException;
	
	List<User> searchUserByEmail(@Param("email") String email )  throws BadSqlGrammarException;
	
	int saveUser(User u)  throws BadSqlGrammarException;
	
	List<User> findAllUsers() throws BadSqlGrammarException;

	int deleteUser(int id)  throws BadSqlGrammarException;
	
	
	
    
}
