package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.GeneralUser;

@Repository(value="appointmentMapper")
@Component
public interface AppointmentMapper {
	

	int finishAppointment(Appointment apptest);

	int startAppointmentById(@Param("app_id") int app_id, @Param("official_id") int official_id );
	
	Appointment getAppointmentById(@Param("app_id") int app_id);
	
	GeneralUser getUserByAppointmentId(@Param("app_id") int app_id);
	
	List<AppointmentDepartment> findAllUserAppointments(int userId) throws BadSqlGrammarException;
	

}
