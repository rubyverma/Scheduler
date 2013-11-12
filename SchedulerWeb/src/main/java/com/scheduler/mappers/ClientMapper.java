package com.scheduler.mappers;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Client;

@Repository(value="clientMapper")
@Component
public interface ClientMapper {

	int saveClient(Client client) throws BadSqlGrammarException;
}
