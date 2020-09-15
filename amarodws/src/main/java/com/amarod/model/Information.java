package com.amarod.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Information {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int informationId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer", nullable = false)
	private Customer customer;
	private String value;
	private String lang;
	private int orderNo;
	
 //	@ManyToMany
 //   @JoinTable(name = "Information_Keys",
 //       joinColumns = @JoinColumn(name = "informationId", referencedColumnName = "informationId"),
 //       inverseJoinColumns = @JoinColumn(name = "keyId", referencedColumnName = "keyId"))
 //   private Set<KeyValues> keyValues;
	@ManyToOne
	@JoinColumn(name = "keyValues", nullable = false)
	private KeyValues keyValues;
	
}
