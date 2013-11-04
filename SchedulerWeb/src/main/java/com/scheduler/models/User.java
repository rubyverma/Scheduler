package com.scheduler.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	 
	Integer id;
	String email;
	String firstname;
	String lastname;
	
}