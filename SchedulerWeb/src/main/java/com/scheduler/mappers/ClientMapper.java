package com.scheduler.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.Client;

@Repository(value="clientMapper")
@Component
public interface ClientMapper {

	int saveClient(Client client) throws BadSqlGrammarException;
	int verifyClient(@Param("client_id") int client_id);
    String getClientToken(@Param("client_id") int client_id);
	int getLastClientId();
}
