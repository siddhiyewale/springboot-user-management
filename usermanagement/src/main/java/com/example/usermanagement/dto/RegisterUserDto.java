package com.example.usermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class RegisterUserDto {

	@Pattern(
			 regexp =
			 "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$",
			 message =
			 "Password must contain uppercase, lowercase and number"
			)
			private String password;
	
	@Email(message = "Invalid Email Format")
	private String email;
}
