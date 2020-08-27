package com.amarod.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Entity
public class User {

	@Id
	private int recordId;
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
	private String userStatus;
	private LocalDateTime created;

}
