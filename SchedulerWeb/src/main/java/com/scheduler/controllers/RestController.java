package com.scheduler.controllers;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scheduler.models.User;
import com.scheduler.request.CommonResponse;
 
@RequestMapping("/api")
@Controller
public class RestController {
 
	  protected static final String JSON_CONTENT = "application/json";
	  
	  @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = JSON_CONTENT)
	  @ResponseBody
	  public User testGet(@PathVariable int id) {
		  final User u = new User();
		  u.setFirstname("Sumit");
		  u.setLastname("Arora");
		  u.setEmail("sumit@gmail.com");
		  u.setId(id);
		  return u;
	  }
	  
	  @RequestMapping(value = "/save", method = RequestMethod.POST, produces = JSON_CONTENT)
	  @ResponseBody
	  public CommonResponse testPost(@RequestBody final User request) {
		  final User u = request;
		  CommonResponse response = new CommonResponse();
		  response.setResponseCode(200); // 200 means success
		  response.setResponseMessage("Received " + u.getFirstname());
		  return response;
	  }	  
}