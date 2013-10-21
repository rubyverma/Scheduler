package com.scheduler.models;
import lombok.Data;

@Data
public class Departmenttimeslot {

	 private int m_departmentTimeId;
	 private int m_departmentId;
	 private int m_timeslotId;
	 private String m_weekdays;
	 private int m_capacity;
	 
	 public Departmenttimeslot()
	 {
		 
	 }
	 
	 public Departmenttimeslot(int _departmentTimeId, int _departmentId, int _timeslotId, String _weekdays,
			 					int _capacity)
	 {
		 this.m_departmentTimeId = _departmentTimeId;
		 this.m_departmentId = _departmentId;
		 this.m_timeslotId = _timeslotId;
		 this.m_weekdays = _weekdays;
		 this.m_capacity = _capacity;
		 
	 }
}
