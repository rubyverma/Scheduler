package com.scheduler.models;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
	
	private int announcementId;
	private int officialId;
	private String gcmMessageId;
	private String announcementHeader;
	private String announcementDescription;
	private Date announcementDate;
}
