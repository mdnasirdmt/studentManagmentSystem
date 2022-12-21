package com.platfromCommons.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addId;

	@NotEmpty
	@Size(min = 6)
	private Integer pinCode;

	@NotEmpty
	private String city;

	@NotEmpty
	private String state;

	@NotEmpty
	private String addressType;

}
