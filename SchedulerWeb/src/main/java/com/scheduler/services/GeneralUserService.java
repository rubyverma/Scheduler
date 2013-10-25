package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.GeneralUserMapper;

@Component
public class GeneralUserService {
	
    @Autowired(required = true)
    private GeneralUserMapper generalUserMapper;

}
