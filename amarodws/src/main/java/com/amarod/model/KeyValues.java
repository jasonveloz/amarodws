package com.amarod.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "KeyValues")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class KeyValues {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int keyId;
	private String keyName;
	private String level;
	private String icon;

	@JsonIgnore
	@ManyToMany(mappedBy = "keyValues")
	private Set<Information> informations = new HashSet<>();

}
