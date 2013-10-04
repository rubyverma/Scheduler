package com.scheduler.request;

import lombok.Data;

@Data
public class CommonResponse {

	int responseCode = 100;
	String responseMessage = "success";
	Object responseObject;
}
