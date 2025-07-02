package com.ex.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// lombok 이 하는 기본적인 일 - getter 와 setter 를 자동으로 생성해준다.
@Getter	
@Setter 
@NoArgsConstructor 	// 매개변수가 없는 생성자 = 기본 생성자 자동 생성
@AllArgsConstructor	// 모든 매개변수가 있는 생성자		RequestArgsConstructor 는 변수에 final 이 붙었을 때만 사용 (잘 사용안함 - all 사용함)
public class User {
	private String name;
	private int age;
}
