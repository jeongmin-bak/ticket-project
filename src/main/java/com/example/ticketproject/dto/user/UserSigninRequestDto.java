package com.example.ticketproject.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSigninRequestDto {
	private String username;
	private String password;
}
