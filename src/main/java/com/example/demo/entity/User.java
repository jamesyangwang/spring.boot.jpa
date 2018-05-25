package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	public User(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
}
