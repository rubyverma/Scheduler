package com.scheduler.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scheduler.BaseTest;

public class OfficialServiceTest extends BaseTest {

	@Autowired(required=true)
	private OfficialUserService officialService;
	
}
