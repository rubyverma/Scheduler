package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.OfficialUserMapper;
import com.scheduler.models.OfficialUser;

@Component
public class OfficialUserService {
	@Autowired(required = true)
	private OfficialUserMapper officialUserMapper;

	public OfficialUser authenticate(OfficialUser o) {

		OfficialUser i1 = officialUserMapper.authenticate(o);
		if (i1 == null) {
			i1 = new OfficialUser();
			i1.setOfficialId(0);
			return i1;
		}
		return i1;
	}

	public String getFirstName(String userName, String password) {

		return officialUserMapper.getFirstName(userName, password);
	}

	public int getOfficialId(String userName, String password) {

		return officialUserMapper.getOfficialId(userName, password);
	}

}
