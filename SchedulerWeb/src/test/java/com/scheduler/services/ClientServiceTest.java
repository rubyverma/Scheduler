package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;

import com.scheduler.BaseTest;
import com.scheduler.models.DepartmentStatistics;

public class ClientServiceTest extends BaseTest {

	@Autowired(required = true)
	private ClientService clientService;

	
}
