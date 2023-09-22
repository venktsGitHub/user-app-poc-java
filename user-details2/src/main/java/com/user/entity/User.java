package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	String userName;
	String gender;
	int departmentId;
	

}
