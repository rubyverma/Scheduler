package com.scheduler;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.scheduler.controllers.TestUserController;
import com.scheduler.services.TestUserService;

@RunWith(Suite.class)
@SuiteClasses( { TestUserService.class,
	TestUserController.class})
public class AllTests {

}
 