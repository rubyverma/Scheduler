package com.scheduler.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.UnifiedConnectionTester;
import com.scheduler.mappers.AppointmentMapper;
import com.scheduler.models.Appointment;
import com.scheduler.models.DepartmentTimeslotLinkage;

@Component
public class ExpectedMeetingTimeService {

	@Autowired(required = true)
	private DepartmentTimeslotService departmentTimeslotService;

	@Autowired(required = true)
	private AppointmentMapper appointmentMapper;

	private Calendar calendar = Calendar.getInstance();
	private Date currentDate = new Date(calendar.getTime().getTime());
	private Time currentTime = new Time(calendar.getTime().getTime());

	public String getExpectedMeetingTime(@Param("appointmentId") int appointmentId) {

		String expectedMeetingTime = null;

		Appointment appointment = appointmentMapper.getAppointmentById(appointmentId);
		DepartmentTimeslotLinkage bookedTimeslot = departmentTimeslotService.getTimeslotByAppointment(appointment.getDepartmentTimeId());
		Date appointmentDate = appointment.getAppointmentDate();
		List<Appointment> unfinishedAppointments = appointmentMapper.getBeforeAppointments(appointment);
		if (isCurrentDate(appointmentDate)) {
			List<Appointment> finishedAppointments = appointmentMapper.getFinishedAppointments(appointment);
			unfinishedAppointments = appointmentMapper.getBeforeAppointments(appointment);
			System.out.println(finishedAppointments);
			System.out.println(unfinishedAppointments);
			System.out.println(isAfterBeforeTime(bookedTimeslot.getStartTime()));
			System.out.println(isAfterBeforeTime(bookedTimeslot.getStopTime()));
			if (isAfterBeforeTime(bookedTimeslot.getStartTime()) && !isAfterBeforeTime(bookedTimeslot.getStopTime())) {
					if (finishedAppointments.size() > 0) {
						expectedMeetingTime = expectedTimeByAverageMeetingTime(finishedAppointments,unfinishedAppointments,bookedTimeslot);
					} else {
						expectedMeetingTime = expectedTimeByCapacity(unfinishedAppointments,bookedTimeslot);
					}
			}
			else {
				expectedMeetingTime = expectedTimeByCapacity(unfinishedAppointments,bookedTimeslot);
			}
		} else if (isPastFutureDate(appointmentDate)) {
			expectedMeetingTime = expectedTimeByCapacity(unfinishedAppointments,bookedTimeslot);

		} else {
			expectedMeetingTime = "Past date appointment";
		}

		return expectedMeetingTime;

	}

	private boolean isPastFutureDate(Date appointmentdate) {
		if (appointmentdate.after(currentDate)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isCurrentDate(Date appointmentdate) {
		if (appointmentdate.toString().equals(currentDate.toString())) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isAfterBeforeTime(Time time) {

		int hours = time.getHours();
		int minutes = time.getMinutes();
		int seconds = time.getSeconds();
		if ((currentTime.getHours() > hours)|| 
			(currentTime.getHours() == hours && currentTime.getMinutes() > minutes)|| 
			(currentTime.getHours() == hours && currentTime.getMinutes() == minutes && currentTime.getSeconds() > seconds)){
			return true;
		} else {
			return false;
		}
	}

	private int totalMinutes(Time time1, Time time2) {

		int totalMinutes = 0;
		int time1Hours = time1.getHours();
		int time1Minutes = time1.getMinutes();
		int time2Hours = time2.getHours();
		int time2Minutes = time2.getMinutes();
		
		totalMinutes = ((time2Hours - time1Hours) * 60) + (time2Minutes - time1Minutes);
		
		return totalMinutes;
	}
	
	private Time addMinutesToTime(Time time, int minutes) {
		int timeHours = time.getHours();
		int timeMinutes = time.getMinutes();
		int finalHours = timeHours + (minutes/60);
		int finalMinutes = timeMinutes + (minutes%60);
		String stringTime = finalHours + ":" + finalMinutes + ":00";
		Time finalTime =Time.valueOf(stringTime);
		return finalTime;
	}

	private String expectedTimeByCapacity(List<Appointment> appointments, DepartmentTimeslotLinkage bookedTimeslot) {

		String meetingTime = null;
		if (appointments.size() == 0){
			meetingTime = bookedTimeslot.getStartTime().toString();
		}
		else {
			int timeslotMinutes = totalMinutes(bookedTimeslot.getStartTime(), bookedTimeslot.getStopTime());
			System.out.println(bookedTimeslot);
			System.out.println("Start Time: " + bookedTimeslot.getStartTime() + " End Time:  " + bookedTimeslot.getStopTime());
			System.out.println("Total Timeslot minutes: " + timeslotMinutes);
			int averageMeetingTime = timeslotMinutes/bookedTimeslot.getCapacity();
			System.out.println("Average Meeting Time: " + averageMeetingTime);
			int addedMinutes = averageMeetingTime * appointments.size();
			System.out.println("Added time : " + addedMinutes);
			meetingTime = addMinutesToTime(bookedTimeslot.getStartTime(), addedMinutes).toString();
		}
		return meetingTime;
	}

	private String expectedTimeByAverageMeetingTime(List<Appointment> finishedAppointments,List<Appointment> unfinishedAppointments,DepartmentTimeslotLinkage bookedTimeslot) {

		String meetingTime = null;
		int totalMeetingTime = 0;
		for (Appointment app:finishedAppointments){
			totalMeetingTime += totalMinutes(app.getStartTime(), app.getEndTime());
		}

		int averageMeetingTime = totalMeetingTime/finishedAppointments.size();
		int addedMinutes = averageMeetingTime * (finishedAppointments.size() + unfinishedAppointments.size());
		System.out.println(bookedTimeslot);
		System.out.println("Start Time: " + bookedTimeslot.getStartTime() + " End Time:  " + bookedTimeslot.getStopTime());
		System.out.println("Total Timeslot minutes: " + totalMeetingTime);
		System.out.println("Average Meeting Time: " + averageMeetingTime);
		System.out.println("Added time : " + addedMinutes);
		meetingTime = addMinutesToTime(bookedTimeslot.getStartTime(), addedMinutes).toString();
		return meetingTime;
	}

}
