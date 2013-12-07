package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.Client;
import com.scheduler.models.GeneralUser;

@Repository(value="generalUserMapper")
@Component
public interface GeneralUserMapper {

	String getUserRegistrationId(@Param("user_id") int user_id);
    GeneralUser authenticate(GeneralUser gu);
    String getFirstName(@RequestParam("username")String username,@RequestParam("password")String password);
    int getUserId(@RequestParam("username")String userName,@RequestParam("password")String password);
    int saveUser(GeneralUser generaluser) throws BadSqlGrammarException;
	int verifyUser(@Param("userId") int userId);
	String getUserToken(@Param("userId") int userId);
	int getLastUserId();
	int resetPassword(@Param("email") String email,@Param("password") String password);
	int updateGCMRegId(GeneralUser user);
	GeneralUser getGeneralUser(@Param("userId") int userId);
	int updateUser(GeneralUser generaluser);
	int updatePassword(GeneralUser generaluser);
	List<Client> getClients();

}
