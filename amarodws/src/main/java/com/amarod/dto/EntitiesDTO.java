package com.amarod.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EntitiesDTO {

	private String entity;
	private String entityDescription;
	private String entityNote;
	private String lang;
	private String img;
	private int orderNo;

}
