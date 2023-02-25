package com.itheima.mybatis_plus_learn.domain;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String name;
	private String password;
	private Integer age;
	private String tel;
}
