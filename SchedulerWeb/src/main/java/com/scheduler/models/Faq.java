package com.scheduler.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faq {
	
	private int faqId;
	private int categoryId;
	private int officialId;
	private String faqQuestion;
	private String faqAnswer;
	private Date createDate;
}
