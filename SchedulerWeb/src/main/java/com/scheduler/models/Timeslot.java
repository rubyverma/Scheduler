/**
 * @file		Timeslot.java
 * @brief		A data access class for the "timeslot" table of the scheduler database.
 * @details			 
 * @author 		Shalin Banjara
 * @date 		October 20, 2013.
 * @version 	1.0
 */

package com.scheduler.models;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timeslot {
	/**
	 * @brief Unique Id for each timeslot object referenced from the primary key
	 *        of the table timeslot table.
	 */
	private int timeslotId;
	/**
	 * @brief Stores the client Id for the timeslot.
	 */
	private int clientId;

	/**
	 * @brief Stores the starting time for the timeslot.
	 */
	private Time startTime;
	/**
	 * @brief Stores the ending time for the timeslot.
	 */
	private Time stopTime;
	/**
	 * @brief Stores the description for the timeslot.
	 */
	private String description;
}
