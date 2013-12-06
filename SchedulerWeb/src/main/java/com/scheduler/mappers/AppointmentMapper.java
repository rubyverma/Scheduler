package com.scheduler.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.scheduler.models.Appointment;
import com.scheduler.models.AppointmentList;
import com.scheduler.models.AppointmentDepartment;
import com.scheduler.models.GeneralUser;

@Repository(value = "announcementMapper")
@Component
public interface AppointmentMapper {

	List<Appointment> getFinishedAppointments(Appointment appointment);

	List<Appointment> getBeforeAppointments(Appointment appointment);

	int saveAppointment(Appointment appointment);

	int finishAppointment(Appointment apptest);

	int startAppointmentById(@Param("app_id") int app_id, @Param("official_id") int official_id);

	Appointment getAppointmentById(@Param("app_id") int app_id);

	GeneralUser getUserByAppointmentId(@Param("app_id") int app_id);

	List<AppointmentList> getAllAppointment(@Param("departmentId") int departmentId);

	List<AppointmentDepartment> findAllUserAppointments(int userId) throws BadSqlGrammarException;

	List<Appointment> findAllAppointments(int userId) throws BadSqlGrammarException;

	Appointment findNextAppointment(@Param("department_id") int department_id);

	GeneralUser getNextUserInQueue(@Param("department_id") int department_id);

	int cancelAppointment(int appointmentId) throws BadSqlGrammarException;

	int userLate(int appointmentId) throws BadSqlGrammarException;

	int getAppointmentCount(@Param("department_id") int departmentId);
	
	int getAppointmentCountByUserId(@Param("userId") int userId);
	
	int getAppointmentCountByClientId(@Param("clientId") int clientId);

}
