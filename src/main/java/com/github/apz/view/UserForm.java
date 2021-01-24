package com.github.apz.view;

import lombok.Data;

@Data
public class UserForm {
	private String userId;
	private String userName;

	public void initialized() {
		this.userId = "";
		this.userName = "";
	}
}
