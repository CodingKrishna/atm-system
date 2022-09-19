package com.atm.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString
@AllArgsConstructor
public class User {

	@Id
	int id;

	String name;

	String email;
	
}
