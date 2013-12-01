package com.scheduler.services;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;
import com.scheduler.models.GeneralUser;

public class GeneralUserServiceTest extends BaseTest{

	@Autowired(required=true)
	private GeneralUserService generalUserService;
	
	
}
