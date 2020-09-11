package com.amarod.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Entities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Entities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int entityId;
	private String entity;
	private String entityDescription;
	private String entityNote;
	private String lang;
	private String img;
	private int orderNo;
	@JsonIgnore
	@OneToMany(mappedBy="entity")
    private Set<Customer> customers;
}
