package com.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.mappers.TimeslotMapper;

@Component
public class TimeslotService {

	@Autowired(required = true)
	private TimeslotMapper timeslotMapper;
}
