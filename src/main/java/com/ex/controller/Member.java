package com.ex.controller;

import lombok.Setter;

import java.util.List;

import lombok.Getter;

@Setter
@Getter
public class Member {
	private String username;
	private String password;
	private String email;
	private String gender;
	private List<String> hobbies;
	private String country;
}
