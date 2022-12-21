package com.platfromCommons.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;

	@NotEmpty
	private String courseName;

	@NotEmpty
	private String topics;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Student> students = new ArrayList<>();

}
