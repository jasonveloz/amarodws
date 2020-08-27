package com.amarod.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {

	private int customerId;
	private String customerCode;
	private String customerName;
	private String description;
	private int entity;
	private String img;
	private String lang;
	private int orderNo;

}
