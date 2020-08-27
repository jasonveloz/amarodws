package com.amarod.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
public class LoginDTO {

	@NotBlank
	@Size(max = 30)
	private String username;
	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

}
