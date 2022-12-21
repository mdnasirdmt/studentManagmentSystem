package com.platfromCommons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer unique_student_code;

	@NotNull
	@Size(min = 2, max = 50)
	private String name;

	@NotEmpty
	private String gender;

	@NotEmpty
	private Date dob;

	@Pattern(regexp = "(^([+]\\d{2}([ ])?)?\\d{10}$)", message = "Number should be in format: {+91 1234567890, +911234567890, 1234567890}")
	private String mob;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
	List<Course> courses = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	List<Address> addresses = new ArrayList<>();

}
