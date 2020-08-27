package com.amarod.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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
public class Role {
 
	@Id
	private int recordId;
	@NotBlank(message = "Completar Nombre del Rol")
	private String roleName;
	@NotBlank(message = "Completar Descripcion del Rol")
	private String roleDescription;
	@JsonIgnore
	private LocalDateTime created;

}
