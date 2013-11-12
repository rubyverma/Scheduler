package com.scheduler.mappers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.scheduler.models.Client;
import com.scheduler.models.OfficialUser;

@Repository(value="officialUserMapper")
@Component
public interface OfficialUserMapper {
	OfficialUser authenticate(OfficialUser o);
    String getFirstName(@RequestParam("officialName")String officialName,@RequestParam("password")String password);
    int getOfficialId(@RequestParam("officialName")String officialName,@RequestParam("password")String password);
}
