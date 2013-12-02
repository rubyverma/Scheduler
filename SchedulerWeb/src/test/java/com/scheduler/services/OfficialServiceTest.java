package com.scheduler.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.scheduler.BaseTest;
import com.scheduler.models.OfficialUser;
import static org.junit.Assert.*;

public class OfficialServiceTest extends BaseTest {

	@Autowired(required=true)
	private OfficialUserService officialUserService;
	
	@Test
	public void ChangePasswordTest() {
		int officialId = 1;
		String newPassword = "mynewPassword";
		OfficialUser officalUser = new OfficialUser();
		officalUser.setOfficialId(officialId);
		officalUser.setPassword(newPassword);
		int numberofRowsAffected = officialUserService.updatePassword(officalUser);
		assertTrue("Password is not updated", numberofRowsAffected > 0);
		
		OfficialUser offUser = officialUserService.getOfficialUserById(officialId);
		String officialPassword = offUser.getPassword();
		assertEquals(newPassword, officialPassword);
	}
	
}
