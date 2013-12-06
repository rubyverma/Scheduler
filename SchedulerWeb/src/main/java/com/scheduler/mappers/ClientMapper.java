package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.Category;
import com.scheduler.models.Client;
import com.scheduler.models.Faq;
import com.scheduler.models.DepartmentStatistics;


@Repository(value="clientMapper")
@Component
public interface ClientMapper {

	int saveClient(Client client) throws BadSqlGrammarException;
	int verifyClient(@Param("client_id") int client_id);
    String getClientToken(@Param("client_id") int client_id);
    Client authenticate(Client c);
    String getClientName(@RequestParam("userName")String userName,@RequestParam("password")String password);
    int getClientId(@RequestParam("userName")String userName,@RequestParam("password")String password);
	int getLastClientId();
    int resetPassword(@Param("email") String email,@Param("password") String password);
    List<Faq> getFaqQns(@Param("categoryId")int categoryId);
    List<Category> findAllCategories() throws BadSqlGrammarException;
    List<DepartmentStatistics> getStatistics() throws BadSqlGrammarException;
    Client getClientById(int clientId);
	// Author - Shalin Banjara
    int updateClientById(Client client);
	// Author - Shalin Banjara
    int updateClientPasswordById(Client client);
	int getClientId(String to);

}
