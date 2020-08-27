package com.amarod.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

	@NotBlank
	@Size(max = 30)
	private String username;
	@NotBlank
	@Size(max = 50)
	private String firstName;
	@NotBlank
	@Size(max = 50)
	private String lastName;
	@Email
	@Size(max = 50)
	private String email;
	@JsonIgnore
	@NotBlank
	@Size(min = 6, max = 30)
	private String password;
}
