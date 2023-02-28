 package com.masai.entity;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

	@NotNull
	@Size(min = 10, max = 10 , message = "mobile number should be 10 digit number")
	private String mobileNumber;
	
	@Size(min = 6, max = 15, message = "Password length should be 6 - 15 character")
	@NotBlank
	@Pattern(regexp = "[a-z]{2,7}[A-Z]{2,7}[#@$%&*]{1,2}[0-9]{1,9}", message = "password should look like abcABC@999, Morethan 2 lowercase, upercase and number ")
	private String password;
	
	
}
