package com.example.agw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@JsonIgnoreProperties
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	@Transient
	int age;
}
