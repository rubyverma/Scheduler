package com.scheduler.models;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
	
	private int notificationId;
	private int officialId;
	private int userId;
	private String gcmMessageId;
	private String notificationHeader;
	private String notificationDescription;
	private int readByUser;
	private Date notificationDate;
}
