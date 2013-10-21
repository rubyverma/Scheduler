/**
 * @file		Timeslot.java
 * @brief		A data access class for the "timeslot" table of the scheduler database.
 * @details			 
 * @author 		Shalin Banjara
 * @date 		October 20, 2013.
 * @version 	1.0
 */

package com.scheduler.models;
import java.sql.Time;
import lombok.Data;

@Data
public class Timeslot {
	/**
	 * @brief		Unique Id for each timeslot object referenced from the primary key of the table timeslot table. 
	 */
		private int m_timeslotId;
	/**
	 * @brief		Stores the starting time for the timeslot.
	 */
		private Time m_startTime;
	/**
	 * @brief		Stores the ending time for the timeslot.
	 */
		private Time m_stopTime;
	/**
	 * @brief		Stores the description for the timeslot.
	 */
		private String m_description;
	
	/**
	 * @brief		Blank constructor for the class
	 * @details		Blank constructor
	 * @param			
	 * @exception
	 */
		public Timeslot(){
		
		}
		
	/**
	 * @brief				Constructor for the class
	 * @details				Blank constructor
	 * @param _timeslotId	Unique ID for each object referenced from timeslot table
	 * @param _startTime	Start time for the time slot
	 * @param _stopTime		Stop time for the time slot
	 * @param _description	Description for the time slot										
	 * @exception
	 */
		public Timeslot(int _timeslotId, Time _startTime, Time _stopTime, String _description){
			m_timeslotId = _timeslotId;
			m_startTime = _startTime;
			m_stopTime = _stopTime;
			m_description = _description;
		}
}
